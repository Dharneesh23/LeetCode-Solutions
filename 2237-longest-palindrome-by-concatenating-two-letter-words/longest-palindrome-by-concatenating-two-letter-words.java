class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        int length = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if (freq.getOrDefault(rev, 0) > 0) {
                // Match found: reverse word exists, form a palindrome pair
                freq.put(rev, freq.get(rev) - 1);
                length += 4; // Two 2-letter words
            } else {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // Now check for a possible middle like "cc", "gg", etc.
        for (String key : freq.keySet()) {
            if (key.charAt(0) == key.charAt(1) && freq.get(key) > 0) {
                hasMiddle = true;
                break;
            }
        }

        // Add 2 if a central word like "gg" can be placed in the middle
        if (hasMiddle) {
            length += 2;
        }

        return length;
    }
}