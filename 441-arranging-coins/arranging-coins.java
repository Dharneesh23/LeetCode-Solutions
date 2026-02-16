class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coinsNeeded = mid * (mid + 1) / 2; // sum of first mid rows
            if (coinsNeeded == n) {
                return (int) mid; // exact match
            } else if (coinsNeeded < n) {
                left = mid + 1; // try more rows
            } else {
                right = mid - 1; // too many coins, reduce rows
            }
        }
        return (int) right; 
    }
}