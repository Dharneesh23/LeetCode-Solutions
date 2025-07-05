class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int ans = -1;
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int num : map.keySet())
        {
            if(map.get(num)==num)
            {
                ans = Math.max(num,ans);
            }
        }
        return ans;
    }
}