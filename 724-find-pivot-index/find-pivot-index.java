class Solution {
    public int pivotIndex(int[] nums) {
        int totalsum = 0;
        int leftsum =0;
        for(int i : nums)
        {
            totalsum+=i;
        }
        for(int i=0;i<nums.length;i++)
        {
            totalsum-=nums[i];
            if(totalsum==leftsum)
            {
                return i;
            }else{
                leftsum+=nums[i];
            }
        }
        return -1;
    }
}