package backtrack;

import java.util.*;

class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
        System.out.println(letterCombinations.letterCombinations("3"));
        System.out.println(letterCombinations.letterCombinations("78"));
        System.out.println(letterCombinations.letterCombinations("678"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, List<String>> numberMap = new HashMap<>();
        numberMap.put('2', Arrays.asList("a", "b", "c"));
        numberMap.put('3', Arrays.asList("d", "e", "f"));
        numberMap.put('4', Arrays.asList("g", "h", "i"));
        numberMap.put('5', Arrays.asList("j", "k", "l"));
        numberMap.put('6', Arrays.asList("m", "n", "o"));
        numberMap.put('7', Arrays.asList("p", "q", "r", "s"));
        numberMap.put('8', Arrays.asList("t", "u", "v"));
        numberMap.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        letterCombinations(digits, numberMap, result, sb, 0);
        return result;
    }

    private void letterCombinations(String digits, Map<Character, List<String>> map, List<String> result, StringBuilder sb, int index) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        List<String> strings = map.get(ch);
        for (int i = 0; i < strings.size(); i++) {
            sb.append(strings.get(i));
            letterCombinations(digits, map, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}