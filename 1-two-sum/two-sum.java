class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int tol =  target-nums[i];
            if(map.containsKey(tol))
            {
                return new int[]{map.get(tol),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
