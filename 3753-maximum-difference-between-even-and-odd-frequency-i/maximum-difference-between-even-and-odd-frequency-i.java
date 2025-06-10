class Solution {
    public int maxDifference(String s) {
       HashMap<Character,Integer>map =new HashMap<>();
       for(char i : s.toCharArray())
       {
        map.put(i,map.getOrDefault(i,0)+1);
       } 
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
       for(int i : map.values())
       {
         if(i%2==0)
         {
            min = Math.min(min,i);
         }else{
            max = Math.max(max,i);
         }
       }
       return max-min;
    }
}