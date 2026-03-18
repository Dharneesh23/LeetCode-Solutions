class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        long[][] ps = new long[m][n]; // prefix sum
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                ps[i][j] = grid[i][j];
                
                if (i > 0) ps[i][j] += ps[i - 1][j];
                if (j > 0) ps[i][j] += ps[i][j - 1];
                if (i > 0 && j > 0) ps[i][j] -= ps[i - 1][j - 1];
                
                // Check if sum <= k
                if (ps[i][j] <= k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}