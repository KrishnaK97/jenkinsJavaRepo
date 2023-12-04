public class P2 {

    public static void main(String[] args) {
        Solution obj = new Solution();
        // int countStrings = obj.CountStrings("1231");
        int countStrings = obj.CountStrings("122321");

        System.out.println(countStrings);
    }

    public int CountStrings(String s) {
        int counter = 0;
        int n = s.length();
        int[][] charFrequency = precomputeFrequency(s);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isGoodsubstring(s, i, j, charFrequency))
                    counter++;
            }
        }

        return counter;
    }

    private int[][] precomputeFrequency(String s) {
        int n = s.length();
        int[][] charFrequency = new int[n][26];
        charFrequency[0][s.charAt(0) - 'a'] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                charFrequency[i][j] = charFrequency[i - 1][j];
            }
            charFrequency[i][s.charAt(i) - 'a']++;
        }

        return charFrequency;
    }

    private boolean isGoodsubstring(String s, int start, int end, int[][] charFrequency) {
        int[] substringFrequency = new int[26];
        for (int i = 0; i < 26; i++) {
            if (start > 0)
                substringFrequency[i] = charFrequency[end - 1][i] - charFrequency[start - 1][i];
            else
                substringFrequency[i] = charFrequency[end - 1][i];
        }

        int maxFreq = getMaxFrequency(substringFrequency);

        for (int freq : substringFrequency) {
            if (freq >= maxFreq)
                return false;
        }

        return true;
    }

    private int getMaxFrequency(int[] arr) {
        int maxFreq = 0;
        for (int freq : arr) {
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }
}
