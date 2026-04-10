class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
       
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            
           
            for (int i = 0; i <= list.size() - 3; i++) {
                int first = list.get(i);
                int third = list.get(i + 2);
                
                int distance = 2 * (third - first);
                minDistance = Math.min(minDistance, distance);
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}