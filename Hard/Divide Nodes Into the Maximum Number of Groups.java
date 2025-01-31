class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int maxGroupsTotal = 0;

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                List<Integer> component = new ArrayList<>();
                if (!collectComponentAndCheckBipartite(adj, color, i, component)) {
                    return -1;
                }
                int maxGroupsComponent = 0;
                for (int node : component) {
                    maxGroupsComponent = Math.max(maxGroupsComponent, bfs(adj, node));
                }
                maxGroupsTotal += maxGroupsComponent;
            }
        }

        return maxGroupsTotal;
    }

    private boolean collectComponentAndCheckBipartite(List<List<Integer>> adj, int[] color, int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    component.add(neighbor);
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int bfs(List<List<Integer>> adj, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] level = new int[adj.size()];
        Arrays.fill(level, -1);
        level[start] = 1;
        int maxLevel = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (level[neighbor] == -1) {
                    level[neighbor] = level[node] + 1;
                    maxLevel = Math.max(maxLevel, level[neighbor]);
                    queue.offer(neighbor);
                }
            }
        }

        return maxLevel;
    }
}
