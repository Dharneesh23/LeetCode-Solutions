class Solution {
    public boolean checkIfPangram(String sentence) {
        String name =  sentence.toLowerCase();
        for(char ch='a';ch<='z';ch++)
        {
            if(name.indexOf(ch)==-1)
            {
                return false;
            }
        }
        return true;
    }
}