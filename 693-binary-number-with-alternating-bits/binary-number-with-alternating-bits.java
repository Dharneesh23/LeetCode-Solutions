class Solution {
    public boolean hasAlternatingBits(int n) {
         int prevBit = n & 1;   // Get last bit
        n = n >> 1;           // Shift right
        
        while (n > 0) {
            int currentBit = n & 1;
            
            if (currentBit == prevBit) {
                return false;
            }
            
            prevBit = currentBit;
            n = n >> 1;
        }
        
        return true;
    }
}