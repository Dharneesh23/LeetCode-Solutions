class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        // Iterate through all possible hours
        for (int hour = 0; hour < 12; hour++) {
            // Iterate through all possible minutes
            for (int minute = 0; minute < 60; minute++) {
                
                // Count total number of 1s in hour and minute
                int totalOnBits = Integer.bitCount(hour) + Integer.bitCount(minute);
                
                if (totalOnBits == turnedOn) {
                    // Format minute with leading zero
                    result.add(hour + ":" + String.format("%02d", minute));
                }
            }
        }
        
        return result;
    }
}