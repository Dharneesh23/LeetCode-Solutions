class Solution {
    public boolean isPalindrome(int x) {
        int a = x;
        int rev = 0;
        if(x<0)
        {
            return false;
        }
        while(x!=0)
        {
            int sum = x%10;
            x=x/10;
            rev = rev*10+sum;
        }
            if(rev==a)
        {
            return true;
        }
         return false;
    }
    }
