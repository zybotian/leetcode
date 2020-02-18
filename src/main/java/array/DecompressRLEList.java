package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRLEList {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> results = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i += 2) {
            int freq = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                results.add(value);
            }
        }
        int[] array = new int[results.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = results.get(i);
        }
        return array;
    }

    public int[] decompressRLElist2(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i += 2) {
            size += nums[i];
        }

        int[] result = new int[size];
        int k = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                result[k++] = nums[i + 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DecompressRLEList test = new DecompressRLEList();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(test.decompressRLElist2(nums)));
    }
}
