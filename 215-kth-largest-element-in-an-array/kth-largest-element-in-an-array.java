class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n<k)
        {
            return 0;
        }
        return nums[n-k];
    }
}