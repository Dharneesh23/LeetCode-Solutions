class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int freq=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i : map.values())
        {
            freq = Math.max(i,freq);
        }
        for(int i : map.values())
        {
            if(i==freq)
            {
                count+=freq;
            }
        }
        return count;
    }
}