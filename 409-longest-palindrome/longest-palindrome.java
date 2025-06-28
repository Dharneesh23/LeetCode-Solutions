class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int length =0;
        boolean odd = false;
        for(int frq : map.values())
        {
            if(frq%2==0)
            {
                length+=frq;

            }else{
                length+=frq-1;
                odd = true;
            }
        }
        if(odd)
        {
            length+=1;
        }
        return length;
    }

}