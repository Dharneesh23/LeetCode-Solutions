class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int ans =0;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i : map.keySet())
        {
            if(map.get(i)==2)
            {
               ans = ans^i;
            }
        }
        return ans;
    }
}