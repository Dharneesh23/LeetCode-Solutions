class Solution {
    public int binaryGap(int n) {
        int prev = -1; 
        int maxDistance = 0;
        int position = 0; 
        
        while (n > 0) {
            if ((n & 1) == 1) { 
                if (prev != -1) {
                    maxDistance = Math.max(maxDistance, position - prev);
                }
                prev = position; 
            }
            n >>= 1; 
            position++;
        }
        
        return maxDistance;
    }
}