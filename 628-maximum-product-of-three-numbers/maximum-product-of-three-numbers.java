class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int product1 =  nums[0]*nums[1]*nums[n-1];
        int product2 = nums[n-1]*nums[n-2]*nums[n-3];
        return Math.max(product1,product2);
    }
}