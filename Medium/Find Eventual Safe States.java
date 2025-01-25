class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int n = graph.length;

        for(int i=0;i<n;i++){
            if(dfs(i,graph,map))
                res.add(i);
        }
        return res;
    }

    public boolean dfs(int node,int graph[][],HashMap<Integer,Boolean> map){
        if(map.containsKey(node))
            return map.get(node);

        map.put(node,false);
        for(int n : graph[node]){
            if(!dfs(n,graph,map)){
                return false;
            }
        }
        map.put(node,true);
        return true;
    }
}
