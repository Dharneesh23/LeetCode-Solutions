import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int start = nums[0];  // start of the current range
        int end = nums[0];    // end of the current range

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // extend the current range
                end = nums[i];
            } else {
                // close current range and add to result
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                // start a new range
                start = end = nums[i];
            }
        }

        // add the last range
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }
}
