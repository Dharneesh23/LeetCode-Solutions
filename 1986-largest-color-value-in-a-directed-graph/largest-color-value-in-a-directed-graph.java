class Solution {
    public int largestPathValue(String colors, int[][] edges) {
         int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        // Build graph
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // DP array: colorCount[i][c] = max count of color c from any path ending at node i
        int[][] colorCount = new int[n][26];

        Queue<Integer> queue = new LinkedList<>();
        
        // Start with all nodes having indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIndex = colors.charAt(node) - 'a';
            colorCount[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, colorCount[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all nodes were visited, there is a cycle
        return visited == n ? maxColorValue : -1;
    }

    }
