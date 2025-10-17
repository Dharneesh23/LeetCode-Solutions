class Solution {
    public int countKeyChanges(String s) {
        int count = 0;
        
        // Convert first character to lowercase for comparison
        char prev = Character.toLowerCase(s.charAt(0));
        
        // Traverse from second character
        for (int i = 1; i < s.length(); i++) {
            char curr = Character.toLowerCase(s.charAt(i));
            
            // If the current key is different from the previous one, increment count
            if (curr != prev) {
                count++;
            }
            
            // Update prev to current
            prev = curr;
        }
        
        return count;
    }
}
