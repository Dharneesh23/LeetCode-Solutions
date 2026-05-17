class Solution {

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return check(arr, start, visited);
    }

    public boolean check(int[] arr, int index, boolean[] visited) {

        // Out of bound or already visited
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }

        // If reached 0
        if (arr[index] == 0) {
            return true;
        }

        // Mark visited
        visited[index] = true;

        // Jump forward or backward
        return check(arr, index + arr[index], visited) ||
               check(arr, index - arr[index], visited);
    }
}