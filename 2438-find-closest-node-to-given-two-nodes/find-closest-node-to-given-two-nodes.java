class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
       int n = edges.length;
        
        int[] dist1 = getDistances(edges, node1, n);
        int[] dist2 = getDistances(edges, node2, n);
        
        int result = -1;
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }
        
        return result;
    }

    private int[] getDistances(int[] edges, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        boolean[] visited = new boolean[n];

        int curr = start;
        int d = 0;
        while (curr != -1 && !visited[curr]) {
            dist[curr] = d++;
            visited[curr] = true;
            curr = edges[curr];
        }

        return dist;
    } 
    }
