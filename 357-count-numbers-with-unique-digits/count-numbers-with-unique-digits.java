class Solution {
    public int countNumbersWithUniqueDigits(int n) {
         if (n == 0) return 1;

        int result = 10; // for n = 1 (0 to 9)
        int uniqueDigits = 9;
        int availableNumber = 9;

        for (int i = 2; i <= n; i++) {
            uniqueDigits = uniqueDigits * availableNumber;
            result += uniqueDigits;
            availableNumber--;
        }

        return result;
    }
}