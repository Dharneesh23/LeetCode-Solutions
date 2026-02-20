class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;
        
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        // Step 1: Split into primitive special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            
            // When count becomes 0 → we found a special substring
            if (count == 0) {
                // Recursively solve inner part
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                list.add("1" + inner + "0");
                start = i + 1;
            }
        }
        
        // Step 2: Sort in descending order
        Collections.sort(list, Collections.reverseOrder());
        
        // Step 3: Join all substrings
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }
        
        return result.toString();
    }
}