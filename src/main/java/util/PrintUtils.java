package util;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PrintUtils {
    public static void print(Object obj, Method method, Object[] args) {
        try {
            long start = System.currentTimeMillis();
            Object result = method.invoke(obj, args);
            long end = System.currentTimeMillis();
            System.out.println("method:[" + method + "] executed, time cost:[" + (end - start) + "], result:[" + result + "]");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void print(int[] data) {
        Arrays.stream(data).forEach(System.out::println);
    }

    public static void printBeauty(int[] data) {
        System.out.println(Arrays.toString(data));
    }

    public static void printBeauty(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printBeauty(String[] st) {
        System.out.println(Arrays.toString(st));
    }
}
