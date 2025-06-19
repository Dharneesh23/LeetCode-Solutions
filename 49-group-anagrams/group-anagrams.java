class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map = new HashMap<>();
        for(String s : strs)
        {
            char[]arr = s.toCharArray();
            Arrays.sort(arr);
            String s1 = String.valueOf(arr);
            if(!map.containsKey(s1))
            {
                map.put(s1,new ArrayList<>());
            }
            map.get(s1).add(s);
        }
        return new ArrayList<>(map.values());
    }
}