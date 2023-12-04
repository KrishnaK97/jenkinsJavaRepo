import java.util.HashSet;
import java.util.Set;

public class Tree2 {

    public static void main(String[] args) {
        Solution obj = new Solution();
        // int countStrings = obj.CountStrings("1231");
        int countStrings = obj.CountStrings("122321");
        System.out.println(countStrings);
    }

    public int CountStrings(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isGoodsubstring(str)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean isGoodsubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        char maxChar = getMaxChar(uniqueChars);
        int max = maxChar - '0';

        for (char c : uniqueChars) {
            int frq = frequency(c, s);
            if (frq >= max) {
                return false;
            }
        }

        return true;
    }

    private char getMaxChar(Set<Character> uniqueChars) {
        char maxChar = '0';
        for (char c : uniqueChars) {
            if (c > maxChar) {
                maxChar = c;
            }
        }
        return maxChar;
    }

    public int frequency(char ch, String s) {
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == ch)
                counter++;
        }
        return counter;
    }
}
