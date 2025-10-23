class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0;
        int doubleDigitSum = 0;

        for (int num : nums) {
            if (num <= 9) {
                singleDigitSum += num;
            } else {
                doubleDigitSum += num;
            }
        }

        int totalSum = singleDigitSum + doubleDigitSum;

        // Check if Alice wins by choosing single-digit numbers
        if (singleDigitSum > totalSum - singleDigitSum) {
            return true;
        }

        // Check if Alice wins by choosing double-digit numbers
        if (doubleDigitSum > totalSum - doubleDigitSum) {
            return true;
        }

        return false; // Alice cannot win
    }
}
