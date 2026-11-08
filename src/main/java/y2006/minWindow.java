package y2006;

public class minWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int lenS = s.length();

        int[] need = new int[128];
        int needCount = 0;
        char[] tCharArray = t.toCharArray();
        for (char ch : tCharArray) {
            if (need[ch] == 0) {
                needCount++;
            }
            need[ch]++;
        }

        int[] window = new int[128];
        int windowCount = 0;
        int left = 0;
        int bestStart = 0, bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < lenS; right++) {
            char currChar = s.charAt(right);
            window[currChar]++;
            if (window[currChar] == need[currChar]) {
                windowCount++;
            }

            while (windowCount == needCount) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    windowCount--;
                }
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        minWindow minWindow = new minWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
    }
}
