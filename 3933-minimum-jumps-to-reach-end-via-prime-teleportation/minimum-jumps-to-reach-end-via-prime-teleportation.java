import java.util.*;

class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;

        // Map: prime factor -> list of indices divisible by that prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> factors = getPrimeFactors(nums[i]);

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        // To avoid processing same prime multiple times
        Set<Integer> usedPrime = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int i = q.poll();

                if (i == n - 1) {
                    return steps;
                }

                // Move left
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // Move right
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // Prime teleportation
                if (isPrime(nums[i])) {

                    int p = nums[i];

                    if (!usedPrime.contains(p)) {

                        usedPrime.add(p);

                        List<Integer> nextIndices = map.getOrDefault(p, new ArrayList<>());

                        for (int idx : nextIndices) {

                            if (!visited[idx]) {
                                visited[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    // Check prime
    private boolean isPrime(int x) {

        if (x < 2) {
            return false;
        }

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Get distinct prime factors
    private List<Integer> getPrimeFactors(int x) {

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {

                factors.add(i);

                while (x % i == 0) {
                    x /= i;
                }
            }
        }

        if (x > 1) {
            factors.add(x);
        }

        return factors;
    }
}