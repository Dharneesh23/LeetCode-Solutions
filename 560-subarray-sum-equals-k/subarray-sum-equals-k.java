class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int sum =0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum==k)
            {
                count++;
            }if(map.get(sum-k)!=null)
            {
                count = count+map.get(sum-k);
            }
            Integer prv = map.get(sum);
            if(prv==null)
            {
                map.put(sum,1);
            }else{
                map.put(sum,prv+1);
            }
        }
        return count;
    }
}