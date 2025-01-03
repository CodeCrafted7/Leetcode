class Solution {
    static int[] height;
    static int diameter;
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        
        List<List<Integer>> tree1 = new ArrayList<>();
        int n=edges1.length+1;
        for(int i=0;i<n;++i)
        {
            tree1.add(new ArrayList<>());
        }
        for(int[] e : edges1)
        {
            int u = e[0], v = e[1];
            tree1.get(u).add(v);
            tree1.get(v).add(u);
        }
        
        List<List<Integer>> tree2 = new ArrayList<>();
        n=edges2.length+1;
        for(int i=0;i<n;++i)
        {
            tree2.add(new ArrayList<>());
        }
        for(int[] e : edges2)
        {
            int u = e[0], v = e[1];
            tree2.get(u).add(v);
            tree2.get(v).add(u);
        }
        
        height = new int[edges1.length+1];
        diameter = 0;
        dfs(tree1, 0, -1);
        int d1 = diameter;
        System.out.println(diameter);
        
        height = new int[edges2.length+1];
        diameter = 0;
        dfs(tree2, 0, -1);
        int d2 = diameter;
        System.out.println(diameter);
        
        return Math.max(Math.max(d1, d2), (int)Math.ceil((double)d1/2) + (int)Math.ceil((double)d2/2) + 1);
        
        
        
    }
    static void dfs(List<List<Integer>> tree, int u, int par)
      {

        int max1 = 0;
        int max2 = 0;
        
        for (int child : tree.get(u)) {

          if (child == par)
            continue;
          dfs(tree, child, u);

          height[u] = Math.max(height[u], height[child] + 1);

          if (height[child] + 1 >= max1) {
            max2 = max1;
            max1 = height[child] + 1;
          }
          else if (height[child] + 1 > max2) {
            max2 = height[child] + 1;
          }
        }
        
        diameter = Math.max(diameter, height[u]);
        diameter = Math.max(diameter, max1 + max2);
      }

}
