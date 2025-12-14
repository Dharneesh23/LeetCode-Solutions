class Solution {
    public int fib(int n) {
        if(n==1)return 1;
        if(n==0)return 0;
       int first = 0;
       int second = 1;
       int ans = 0;
       for(int i=2;i<=n;i++)
       {
         int next = first+second;
         first = second;
         second = next;
        
       }
       return second;
    }
}