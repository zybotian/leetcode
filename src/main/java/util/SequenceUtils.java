package util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class SequenceUtils {
    public static int[] generate(int num) {
        int[] result = new int[num];
        Random random = new Random();
        int count = 0;
        while (count < num) {
            int current = random.nextInt(1000000);
            result[count++] = current;
        }

        Arrays.sort(result);

        return result;
    }
}
