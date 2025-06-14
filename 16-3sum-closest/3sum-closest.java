class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;;
        for(int i=0;i<nums.length-1;i++)
        {
            int left = i+1;
            int right = nums.length-1;
            while(left<right)
            {
                int currentsum = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-currentsum)<Math.abs(target-closet))
                {
                    closet = currentsum;
                }
                if(currentsum<target)
                {
                    left++;
                }else if(currentsum>target)
                {
                    right--;
                }else{
                    return target;
                }
            }

        }
        return closet;
    }
}