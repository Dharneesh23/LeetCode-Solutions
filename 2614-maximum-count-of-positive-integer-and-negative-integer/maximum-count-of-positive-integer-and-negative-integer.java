class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                pos++;
            }else if(nums[i]<0){
                neg++;
            }

        }
        max = Math.max(pos,neg);
        return max;
    }
}