class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for(char i : s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek()==i)
            {
                stack.pop();
            }else{
                stack.push(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char i : stack)
        {
            ans = ans.append(i);
        }
        return String.valueOf(ans);

    }
}