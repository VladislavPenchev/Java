package GettersAndSetters_fd_2;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));


        Method[] methods = Reflection.class.getDeclaredMethods();

        for (Method method : methods) {
            if(method.getName().startsWith("get")
                    && !method.getReturnType().equals(void.class)
                    && method.getParameterTypes().length == 0){

                getters.add(method);

            }else if(method.getName().startsWith("set")
                    && !method.getReturnType().equals(void.class)
                    && method.getParameterTypes().length == 1){

                setters.add(method);

            }
        }

        for (Method getter : getters) {
            System.out.println(getter.getName() + " will return " + getter.getReturnType());
        }

        for (Method setter: setters) {
            System.out.println(setter.getName() + " and will set of " + setter.getParameterTypes()[0].getSimpleName());
        }


    }
}
