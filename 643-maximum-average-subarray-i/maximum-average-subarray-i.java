class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avgsum =Integer.MAX_VALUE;
        double windowsum =0;
        for(int i=0;i<k;i++)
        {
            windowsum+=nums[i];
        }
         avgsum = windowsum/k;
        for(int i=k;i<nums.length;i++)
        {
            windowsum+=nums[i]-nums[i-k];
            avgsum = Math.max(windowsum/k,avgsum);
        }
        return avgsum;
    }
}