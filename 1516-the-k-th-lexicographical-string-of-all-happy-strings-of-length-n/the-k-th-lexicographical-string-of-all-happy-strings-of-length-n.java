class Solution {

     List<String> list = new ArrayList<>();
    public String getHappyString(int n, int k) {
         generate("", n);

        if (k > list.size()) {
            return "";
        }
        return list.get(k - 1);
    }

    public void generate(String s, int n) {
        if (s.length() == n) {
            list.add(s);
            return;
        }

        char[] ch = {'a','b','c'};

        for(char c : ch){
            if(s.length() == 0 || s.charAt(s.length()-1) != c){
                generate(s + c, n);
            }
    }
}
}