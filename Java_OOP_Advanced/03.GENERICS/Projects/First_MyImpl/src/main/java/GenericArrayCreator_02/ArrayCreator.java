package GenericArrayCreator_02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {

    public static <T> T[] create(int length, T item){
        T[] array = (T[]) new Object[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }

        return array;
    }

    public static <T> T[] create(Class<T> klass, int length, T item){
        T[] array = (T[]) Array.newInstance(klass, length);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }

        return array;
    }
}
