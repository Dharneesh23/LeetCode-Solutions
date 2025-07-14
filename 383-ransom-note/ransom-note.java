class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[]count = new int[26];
        for(char c : magazine.toCharArray())
        {
            count[c-'a']++;
        }
        for(char ch : ransomNote.toCharArray())
        {
            if(count[ch-'a']==0)
            {
                return false;
            }
          count[ch-'a']--;
        }
        return true;
    }
}