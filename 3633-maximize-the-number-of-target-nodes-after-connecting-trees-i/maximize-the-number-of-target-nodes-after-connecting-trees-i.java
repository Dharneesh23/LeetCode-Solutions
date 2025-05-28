class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
         int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] tree1 = buildGraph(n, edges1);
        List<Integer>[] tree2 = buildGraph(m, edges2);

        if (k == 0) {
            // Only the node itself is reachable, no contribution from other tree
            int[] answer = new int[n];
            Arrays.fill(answer, 1);
            return answer;
        }

        int[][] dist1 = bfsAllPairs(tree1, n);
        int[][] dist2 = bfsAllPairs(tree2, m);

        // count nodes in tree1 within distance k from each node
        int[] count1 = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int x = 0; x < n; x++) {
                if (dist1[i][x] <= k) cnt++;
            }
            count1[i] = cnt;
        }

        // count nodes in tree2 within distance k-1 from each node
        int distLimit = k - 1;
        int[] count2 = new int[m];
        for (int j = 0; j < m; j++) {
            int cnt = 0;
            for (int y = 0; y < m; y++) {
                if (dist2[j][y] <= distLimit) cnt++;
            }
            count2[j] = cnt;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < m; j++) {
                maxVal = Math.max(maxVal, count1[i] + count2[j]);
            }
            answer[i] = maxVal;
        }

        return answer;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return graph;
    }

    private int[][] bfsAllPairs(List<Integer>[] graph, int n) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int nei : graph[node]) {
                    if (dist[i][nei] == Integer.MAX_VALUE) {
                        dist[i][nei] = dist[i][node] + 1;
                        q.offer(nei);
                    }
                }
            }
        }
        return dist;
    }
}