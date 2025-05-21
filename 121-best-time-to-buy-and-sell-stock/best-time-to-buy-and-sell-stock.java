class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        for(int i=1;i<prices.length;i++)
        {
            int cost = prices[i]-buy;
            sell = Math.max(cost,sell);
            buy = Math.min(buy,prices[i]);
        }
        return sell;
    }
}