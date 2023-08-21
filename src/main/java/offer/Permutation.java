package offer;

import util.PrintUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {
        PrintUtils.printBeauty(permutation("a"));
        PrintUtils.printBeauty(permutation("ab"));
        PrintUtils.printBeauty(permutation("abc"));
        PrintUtils.printBeauty(permutation("abcd"));
        PrintUtils.printBeauty(permutation("abcde"));
        PrintUtils.printBeauty(permutation("aab"));
    }


    public static String[] permutationV3(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        if (s.length() == 1) {
            return new String[]{s};
        }

        Set<String> result = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0, size = chars.length; i < size; i++) {
            char[] left = i > 0 ? Arrays.copyOfRange(chars, 0, i) : null;
            char[] right = i < size - 1 ? Arrays.copyOfRange(chars, i + 1, size) : null;
            String value = (left != null ? new String(left) : "") + (right != null ? new String(right) : "");

            String[] permutation = permutationV3(value);
            for (int j = 0; j < permutation.length; j++) {
                result.add(chars[i] + permutation[j]);
            }
        }

        return result.toArray(new String[0]);
    }


    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        if (s.length() == 1) {
            return new String[]{s};
        }

        Set<String> result = new HashSet<>();
        for (int i = 0, size = s.length(); i < size; i++) {
            String left = i > 0 ? s.substring(0, i) : "";
            String right = i < size - 1 ? s.substring(i + 1, size) : "";
            String value = left + right;

            String[] permutation = permutation(value);
            for (int j = 0; j < permutation.length; j++) {
                result.add(s.charAt(i) + permutation[j]);
            }
        }

        return result.toArray(new String[0]);
    }
}
