class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1];
        while(left<=right)
        {
            int mid = (left+right)/2;
            int sum =0;
            for(int i : nums)
            {
                sum+=Math.ceil((double)(i)/mid);
            }
            if(sum<=threshold)
            {
                right = mid-1;
            }else{
                left =  mid+1;
            }
        }
        return left;
    }
}