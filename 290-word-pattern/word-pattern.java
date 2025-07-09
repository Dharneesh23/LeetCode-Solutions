class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> charstr = new HashMap<>();
        HashMap<String,Character> strchar = new HashMap<>();
        String[]word = s.split(" ");
        if(pattern.length()!=word.length)
        {
            return false;
        }
        for(int i=0;i<pattern.length();i++)
        {
            char ch = pattern.charAt(i);
            String w = word[i];
            if(charstr.containsKey(ch))
            {
                if(!charstr.get(ch).equals(w))
                {
                    return false;
                }
            }
                else{
                    charstr.put(ch,w);
                }
            
            if(strchar.containsKey(w))
            {
                if(!strchar.get(w).equals(ch))
                {
                    return false;
                }
            }
                else{
                    strchar.put(w,ch);
                }
            
        }
        return true;
    }
}