package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static javax.swing.UIManager.get;

public class Main {

    private static final String className = "BlackBoxInt";
    private static final String classPath = "pr02PrivateClassFiddling.com.";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BlackBoxInt blackBoxInt = null;
        try {
            Class<?> blackBoxIntClass = Class.forName(classPath + className);
            Constructor<?> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();

            String line;
            while (!"END".equals(line = reader.readLine())) {
                String[] lineArgs = line.split("_");

                Method declaredMethod = blackBoxInt.getClass().getDeclaredMethod(lineArgs[0], int.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(blackBoxInt, Integer.parseInt(lineArgs[1]));

				Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
                innerValue.setAccessible(true);
				System.out.println(innerValue.get(blackBoxInt));
			}

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
