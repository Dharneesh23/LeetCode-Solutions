class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long baseSum = 0;
        List<Integer> deltas = new ArrayList<>();

        for (int num : nums) {
            int flipped = num ^ k;
            baseSum += num;
            deltas.add(flipped - num);
        }

        // Sort deltas in descending order of gain
        deltas.sort((a, b) -> Integer.compare(b, a));

        long maxSum = baseSum;
        long currentSum = baseSum;
        int count = 0;

        for (int delta : deltas) {
            count++;
            currentSum += delta;
            if (count % 2 == 0) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
    }