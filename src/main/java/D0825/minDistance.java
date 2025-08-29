package D0825;

class minDistance {

    public static void main(String[] args) {
        minDistance minDistance = new minDistance();
        System.out.println(minDistance.minDistance("horse", "ros"));
        System.out.println(minDistance.minDistance("intention", "execution"));
    }


    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] result = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            result[i][0] = i;
        }

        for (int j = 0; j < len2 + 1; j++) {
            result[0][j] = j;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.min(Math.min(result[i - 1][j], result[i][j - 1]), result[i - 1][j - 1]) + 1;
                }
            }
        }
        return result[len1][len2];
    }
}