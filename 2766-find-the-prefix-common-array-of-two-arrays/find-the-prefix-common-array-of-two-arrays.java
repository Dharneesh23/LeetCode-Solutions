class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        int[] result = new int[n];

        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];

        int common = 0;

        for (int i = 0; i < n; i++) {

            seenA[A[i]] = true;

            if (seenA[B[i]]) {
                common++;
            }

            seenB[B[i]] = true;

            if (A[i] != B[i] && seenB[A[i]]) {
                common++;
            }

            result[i] = common;
        }

        return result;
    }
}