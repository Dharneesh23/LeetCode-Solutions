class Solution {

    public int minimumDistance(String word) {
        int n = word.length();
        Integer[][] dp = new Integer[n][26];
        return helper(word, 0, -1, dp);
    }

    private int helper(String word, int index, int otherFinger, Integer[][] dp) {
        if (index == word.length()) return 0;

        if (otherFinger != -1 && dp[index][otherFinger] != null) {
            return dp[index][otherFinger];
        }

        int curr = word.charAt(index) - 'A';

        // Option 1: Use same finger (move from previous char)
        int useSame = 0;
        if (index > 0) {
            int prev = word.charAt(index - 1) - 'A';
            useSame = dist(prev, curr);
        }
        useSame += helper(word, index + 1, otherFinger, dp);

        // Option 2: Use other finger
        int useOther = 0;
        if (otherFinger != -1) {
            useOther = dist(otherFinger, curr);
        }
        useOther += helper(word, index + 1, index > 0 ? word.charAt(index - 1) - 'A' : -1, dp);

        int ans = Math.min(useSame, useOther);

        if (otherFinger != -1) {
            dp[index][otherFinger] = ans;
        }

        return ans;
    }

    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}