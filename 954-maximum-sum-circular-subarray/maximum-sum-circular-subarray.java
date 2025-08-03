class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int currentsum =0;
        int total =0;
        for(int i : nums)
        {
            currentsum+=i;
            if(currentsum>max)
            {
              max = currentsum; 
            }
            if(currentsum<0)
            {
                currentsum =0;
            }
            total+=i;
        }
        currentsum =0;
        for(int i : nums)
        {
            currentsum +=i;
            if(currentsum<min)
            {
             min = currentsum;
            }
            if(currentsum>0)
            {
                currentsum =0;
            }
        }
        if(total==min)
        {
            return max;
        }
        return Math.max(max,total-min);
    }
}