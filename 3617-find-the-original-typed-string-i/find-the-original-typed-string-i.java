import java.util.*;

class Solution {
    public int possibleStringCount(String word) {
        Set<String> possible = new HashSet<>();
        possible.add(word); // the original word is always valid

        int n = word.length();
        int i = 0;

        while (i < n) {
            int j = i;

            // Find the group of repeated characters
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }

            int len = j - i;

            // If group has 2 or more characters, try reducing it
            if (len > 1) {
                for (int k = 1; k < len; k++) {
                    // Build new string with this group shortened to length k
                    String newWord = word.substring(0, i) + repeat(word.charAt(i), k) + word.substring(j);
                    possible.add(newWord);
                }
            }

            i = j;
        }

        return possible.size();
    }

    private String repeat(char ch, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) sb.append(ch);
        return sb.toString();
    }
}
