class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer>map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;
        int pre = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
        int current = map.get(s.charAt(i));
            if(current<pre)
            {
                total = total - current;
            }else{
                total = total+current;
            }
            pre = current;
        }
        return total;
    }
}