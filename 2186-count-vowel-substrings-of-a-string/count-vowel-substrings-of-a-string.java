class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int count =0;
        for(int i=0;i<n;i++)
        {
            Set<Character>set = new HashSet<>();
            for(int j=i;j<n;j++)
            {
                char ch = word.charAt(j);
                if(!check(ch))
                {
                    break;
                }
                set.add(ch);
                if(set.size()==5)
                {
                    count++;
                }
            }
           
        }
         return count;
    }
    public boolean check (char ch)
    {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}