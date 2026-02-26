class Solution {
    public int numSteps(String s) {
         if (s.equals("1")) return 0;

        StringBuilder sb = new StringBuilder(s);
        int steps = 0;

        while (!sb.toString().equals("1")) {

            // If even (last bit 0)
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);  // divide by 2
            } 
            // If odd (last bit 1)
            else {
                int i = sb.length() - 1;

                // Handle carry while adding 1
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }

                if (i >= 0) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.insert(0, '1');
                }
            }

            steps++;
        }

        return steps;
    }
}