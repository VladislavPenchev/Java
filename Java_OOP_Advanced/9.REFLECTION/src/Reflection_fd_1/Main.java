package Reflection_fd_1;


import javafx.scene.effect.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> aClass = Reflection.class;
        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces)
            System.out.println(anInterface);
        //Reflection ref = aClass.newInstance();//Deprecated since Java 9
        Reflection ref = aClass.getDeclaredConstructor().newInstance();
        System.out.println(ref);


    }
}
