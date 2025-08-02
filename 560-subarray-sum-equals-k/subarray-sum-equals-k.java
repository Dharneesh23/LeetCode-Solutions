class Solution {
    public int subarraySum(int[] nums, int k) {
        int prifix[] = new int[nums.length+1];
        int count =0;
        for(int i=0;i<nums.length;i++)
        {
            prifix[i+1] = prifix[i]+nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<=nums.length;j++)
            {
                if(prifix[j]-prifix[i]==k)
                {
                    count++;
                }
            }
        }
        return count;
    }
}