import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                if (fullLakes.containsKey(lake)) {
                    // find a dry day after last full day
                    Integer dryDay = dryDays.ceiling(fullLakes.get(lake));
                    if (dryDay == null) return new int[0]; // no dry day to prevent flood
                    ans[dryDay] = lake;   // dry this lake
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i);
                ans[i] = -1; // rain day
            } else {
                // dry day, assign default 1 (can be changed later)
                dryDays.add(i);
                ans[i] = 1;
            }
        }

        return ans;
    }
}
