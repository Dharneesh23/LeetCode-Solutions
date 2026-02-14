class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
         double[][] dp = new double[101][101];
        
        // Pour champagne into top glass
        dp[0][0] = poured;
        
        // Process row by row
        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                
                // If overflow exists
                if (dp[row][col] > 1.0) {
                    double excess = dp[row][col] - 1.0;
                    
                    // Distribute equally to next row
                    dp[row + 1][col] += excess / 2.0;
                    dp[row + 1][col + 1] += excess / 2.0;
                    
                    // Current glass remains full
                    dp[row][col] = 1.0;
                }
            }
        }
        
        return dp[query_row][query_glass];
    }
}