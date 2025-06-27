class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int n : nums)
        {
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        return find(min,max);
    }
    public int find(int a, int b)
    {
        while(b!=0)
        {
            int temp =  b ;
            b = a%b;
            a = temp;
        }
        return a ;
    }
}