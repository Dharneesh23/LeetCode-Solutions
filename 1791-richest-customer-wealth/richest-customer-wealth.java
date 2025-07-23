class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans =0;
        for(int i=0;i<accounts.length;i++)
        {
            int currSum =0;
            for(int j=0;j<accounts[i].length;j++)
            {
                currSum+= accounts[i][j];
            }
            ans = Math.max(ans,currSum);
        }
        return ans;
    }
}