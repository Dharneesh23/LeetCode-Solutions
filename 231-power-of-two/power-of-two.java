class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1)
        {
            return true;
        }
        if(n%2!=0)
        {
            return false;
        }
        return power (n,1);
    }
    public boolean power(int n , int pow)
    {
        if(Math.pow(2,pow)==n)
        {
            return true;
        }
        if(Math.pow(2,pow)>n)
        {
            return false;
        }
        return power(n,pow+1);
    }
}