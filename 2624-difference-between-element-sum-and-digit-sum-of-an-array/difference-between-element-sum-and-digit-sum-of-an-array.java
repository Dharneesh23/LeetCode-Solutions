class Solution {
    public int differenceOfSum(int[] nums) {
        int sum =0;
        int digit =0;
        for(int a : nums)
        {
            sum+=a;
            int n = a;
            while(n>0)
            {
                digit+=n%10;
                n/=10;
            }
        }
       return sum-digit;
    }
}