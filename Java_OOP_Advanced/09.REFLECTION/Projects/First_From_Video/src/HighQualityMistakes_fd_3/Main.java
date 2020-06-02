package HighQualityMistakes_fd_3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.lang.reflect.Field;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        fields.addAll(Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(m -> !Modifier.isPrivate(m.getModifiers())).collect(Collectors.toList()));

        getters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get")
                        && !void.class.equals(m.getReturnType()))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .collect(Collectors.toList()));

        setters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set")
                        && void.class.equals(m.getReturnType()))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .collect(Collectors.toList()));


        for (Field field : fields) {
            System.out.println(field.getName());
        }

        for (Method getter: getters) {
            System.out.println(getter.getName());
        }

        for (Method setter: setters) {
            System.out.println(setter.getName());
        }
    }
}
