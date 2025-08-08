class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n =  haystack.length();
        int[]arr = lps(needle);
        int ans = -1;
        int i=0;
        int j=0;
        while(i<n)
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
            }if(j==m)
            {
                return i-j;
            }else if(i<n && haystack.charAt(i)!=needle.charAt(j))
            {
                if(j!=0)
                {
                    j = arr[j-1];
                }else{
                    i++;
                }
            }
        }
        return ans;
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
            }else {
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