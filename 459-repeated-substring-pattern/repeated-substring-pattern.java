class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[]arr = lps(s);
        int len = arr[s.length()-1];
        return len>0&&n%(n-len)==0;
    }
    public int[] lps(String parttern)
    {
        int n = parttern.length();
        int i=1;
        int j=0;
        int[]arr = new int[n];
        while(i<n)
        {
            if(parttern.charAt(i)==parttern.charAt(j))
            {
                j++;
                arr[i] = j;
                i++;
            }else{
                if(j!=0)
                {
                    j=arr[j-1];
                    
                }else{
                    arr[i] = 0;
                    i++;
                }
            }
        }
        return arr;
    }
}