class Solution {
    private class Node{
        private String key;
        private double val;

        public Node(String key, double val){
            this.key = key;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = createGraph(equations, values);
        double[] ans = new double[queries.size()];

        for(int i=0; i<ans.length; i++){
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);
        }

        return ans;
    }

    private double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> graph){
        if(! graph.containsKey(s) || ! graph.containsKey(d)) return -1.0;

        if(s.equals(d)) return 1.0;

        visited.add(s);
        for(Node n: graph.get(s)){
            if(! visited.contains(n.key)){
                double ans = dfs(n.key, d, visited, graph);
                if(ans != -1.0) return ans * n.val;
            }
        }

        return -1.0;
    }

    private Map<String, List<Node>> createGraph(List<List<String>> eq, double[] val){
        Map<String, List<Node>> myMap = new HashMap<>();

        for(int i=0; i<eq.size(); i++){
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);

            myMap.putIfAbsent(src, new ArrayList<Node>());
            myMap.putIfAbsent(des, new ArrayList<Node>());

            myMap.get(src).add(new Node(des, val[i]));
            myMap.get(des).add(new Node(src, 1/val[i]));
        }

        return myMap;
    }
}
