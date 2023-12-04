import java.util.TreeSet;

class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        // int countStrings = obj.CountStrings("122321");
        int countStrings = obj.CountStrings("1231");
        System.out.println(countStrings);
    }

    public int CountStrings(String s) {
        // Code Here.
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
        int len = s.length();
        int i = 0;
        TreeSet<Character> treeSet = new TreeSet<>();

        while (i != len) {
            char c = s.charAt(i);
            treeSet.add(c);
            i++;
        }

        int max = treeSet.last() - '0';

        for (char c : treeSet) {
            int frq = frequency(c, s);
            if (frq >= max)
                return false;
        }

        return true;
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