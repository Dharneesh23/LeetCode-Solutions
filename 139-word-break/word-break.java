class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>set = new HashSet<>();
        set.addAll(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n+1];
        f[0] = true;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                String sub = s.substring(j,i);
                if(f[j]&&set.contains(sub))
                {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}