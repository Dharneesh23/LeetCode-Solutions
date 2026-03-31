class Solution {
    public String generateString(String str1, String str2) {
            int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] res = new char[len];
        Arrays.fill(res, '?');

        // Step 1: Apply 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] == '?' || res[i + j] == str2.charAt(j)) {
                        res[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 2: Fill remaining positions
        for (int i = 0; i < len; i++) {
            if (res[i] == '?') {
                res[i] = 'a'; // try smallest
            }
        }

        // Step 3: Fix 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If equal → break it
                if (match) {
                    boolean fixed = false;

                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;

                        // Try replacing with next possible char
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != str2.charAt(j)) {
                                char old = res[idx];
                                res[idx] = c;

                                // Check if any 'T' breaks
                                if (isValidT(res, str1, str2)) {
                                    fixed = true;
                                    break;
                                }

                                res[idx] = old; // revert
                            }
                        }
                        if (fixed) break;
                    }

                    if (!fixed) return "";
                }
            }
        }

        return new String(res);
    }

    // Helper: Check all 'T' constraints
    private static boolean isValidT(char[] res, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != str2.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}