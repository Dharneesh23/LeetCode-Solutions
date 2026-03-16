import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // radius 0 (single cell)
                set.add(grid[i][j]);

                int maxSize = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));

                for (int size = 1; size <= maxSize; size++) {
                    int sum = 0;

                    int x = i - size, y = j;

                    // top -> right
                    for (int k = 0; k < size; k++) {
                        sum += grid[x + k][y + k];
                    }

                    // right -> bottom
                    for (int k = 0; k < size; k++) {
                        sum += grid[x + size + k][y + size - k];
                    }

                    // bottom -> left
                    for (int k = 0; k < size; k++) {
                        sum += grid[x + 2 * size - k][y - k];
                    }

                    // left -> top
                    for (int k = 0; k < size; k++) {
                        sum += grid[x + size - k][y - size + k];
                    }

                    set.add(sum);
                }
            }
        }

        int k = Math.min(3, set.size());
        int[] res = new int[k];
        int idx = 0;

        for (int val : set) {
            if (idx == k) break;
            res[idx++] = val;
        }

        return res;
    }
}