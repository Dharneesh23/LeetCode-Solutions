class Solution {
    public boolean hasAllCodes(String s, int k) {
        int totalCodes = 1 << k;  // 2^k
        
        HashSet<String> set = new HashSet<>();
        
        // Sliding window of size k
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
            if (set.size() == totalCodes) {
                return true;
            }
        }
        
        return false;
    }
}