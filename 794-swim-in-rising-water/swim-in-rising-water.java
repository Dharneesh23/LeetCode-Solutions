import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]}); // {row, col, elevation}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], elev = cur[2];

            if (r == n-1 && c == n-1) return elev;
            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >=0 && nr < n && nc >=0 && nc < n && !visited[nr][nc]) {
                    pq.add(new int[]{nr, nc, Math.max(elev, grid[nr][nc])});
                }
            }
        }

        return -1; // should never happen
    }
}
