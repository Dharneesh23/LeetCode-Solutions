class Solution {
    public int myAtoi(String s) {
        int result = 0, sign = 1,n = s.length(),index=0;
         
         while(index<n && s.charAt(index)==' ')
         {
            index++;
         }
         if(index<n)
         {
            if(s.charAt(index)=='-')
            {
                sign = -1;
                index++;
            }else if(s.charAt(index)=='+'){
                index++;

            }
         }
         while(index<n && Character.isDigit(s.charAt(index)))
         {
            int digit = s.charAt(index)-'0';
            if(result>(Integer.MAX_VALUE-digit)/10)
            {
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result*10+digit;
            index++;
         }
         return result*sign;


    }
}