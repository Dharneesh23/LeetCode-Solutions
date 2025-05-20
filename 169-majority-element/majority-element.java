class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int element = 0;
        for(int a : nums)
        {
            if(count==0)
            {
                element = a;
            }
             if(a==element)
            {
                count++;
            }else{
                count--;
            }
        }
        return element;
    }
}