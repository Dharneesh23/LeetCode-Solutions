class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>list = new ArrayList<>();
        if(digits==null||digits.length()==0)
        {
            return list;
        }
        String[]arr = {
            "","", "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  
        };
       Queue<String>queue = new LinkedList<>();
       queue.add("");
       for(char ch : digits.toCharArray())
       {
          String letter =  arr[ch-'0'];
          int size = queue.size();
          for(int i=0;i<size;i++)
          {
             String comb = queue.poll();
             for(char dig : letter.toCharArray())
             {
                queue.add(comb+dig);
             }
          }
       }
       list.addAll(queue);
       return list;
    }
}