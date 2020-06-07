package util;

import java.lang.reflect.Method;

public class PrintUtils {
    public static void print(Object obj, Method method, Object[] args) {
        try {
            long start = System.currentTimeMillis();
            Object result = method.invoke(obj, args);
            long end = System.currentTimeMillis();
            System.out.println("method:[" + method + "] executed, time cost:[" + (end - start) + "], result:[" + result + "]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
