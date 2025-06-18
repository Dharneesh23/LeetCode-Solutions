class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans =  new StringBuilder();
        int count =0;
        for(char c : s.toCharArray())
        {
            if(c==')')
            {
                count--;
            }
            if(count!=0)
            {
                ans = ans.append(c);
            }
            if(c=='(')
            {
                count++;
            }
        }
        return ans.toString();
    }
}