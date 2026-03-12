import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0;
        int right = 200000;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int minStrength) {

        DSU dsu = new DSU(n);

        int usedEdges = 0;
        int upgrades = 0;

        List<int[]> optional = new ArrayList<>();

        // process mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < minStrength) return false;

                if (!dsu.union(u, v)) return false;

                usedEdges++;
            } else {
                optional.add(e);
            }
        }

        // use optional edges without upgrade
        for (int[] e : optional) {
            int u = e[0], v = e[1], s = e[2];

            if (s >= minStrength) {
                if (dsu.union(u, v)) {
                    usedEdges++;
                }
            }
        }

        // use optional edges with upgrade
        for (int[] e : optional) {
            int u = e[0], v = e[1], s = e[2];

            if (s < minStrength && s * 2 >= minStrength) {
                if (upgrades >= k) break;

                if (dsu.union(u, v)) {
                    upgrades++;
                    usedEdges++;
                }
            }
        }

        return usedEdges == n - 1;
    }
}