class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums == null || nums.length == 0) return 0;

        int count =0;
        int max = 0;
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        for(int i : set)
        {
            if(!set.contains(i-1))
            {
                count =1;
                int element = i;
                while(set.contains(element+1))
                {
                    count++;
                    element++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}