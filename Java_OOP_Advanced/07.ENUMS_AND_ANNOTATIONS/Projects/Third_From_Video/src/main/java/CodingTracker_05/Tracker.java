package CodingTracker_05;

import java.lang.reflect.Method;

public class Tracker {

    public static void printMethodByAuthor(Class<?> cl){
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author author = method.getDeclaredAnnotation(Author.class);
            if(author != null){
                System.out.println(String.format("%s: %s", method.getName(), author.name()));
            }
        }
    }
}
