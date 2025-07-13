class Solution {
    public int jump(int[] nums) {
        int reach = 0;
        int ans = 0;
        int currEnd = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            reach = Math.max(reach,i+nums[i]);
            if(i==currEnd)
            {
                ans++;
                currEnd = reach;
            }
        }
        return ans;
    }
}