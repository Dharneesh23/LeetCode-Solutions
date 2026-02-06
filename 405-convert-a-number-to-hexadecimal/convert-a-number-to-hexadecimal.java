class Solution {
    public String toHex(int num) {
         if (num == 0) {
            return "0";
        }

        char[] hexMap = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
        };

        StringBuilder result = new StringBuilder();

        // Process 32 bits (max 8 hex digits)
        while (num != 0) {
            int last4Bits = num & 15;   // get last 4 bits
            result.append(hexMap[last4Bits]);
            num >>>= 4;                // unsigned right shift
        }

        return result.reverse().toString();
    }
}