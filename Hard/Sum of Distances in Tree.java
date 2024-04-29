class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] counts = new int[n];
        Arrays.fill(counts, 1); 
        int[] distanceSums = new int[n];
        postOrder(graph, 0, -1, counts, distanceSums);
        preOrder(graph, 0, -1, counts, distanceSums);
        
        return distanceSums;
    }
    
    
    private void postOrder(ArrayList<Integer>[] graph, int currNode, int parentNode, int[] counts, int[] distanceSums){
        for(int childNode : graph[currNode]){
            
            if(childNode == parentNode) continue;
            postOrder(graph, childNode, currNode, counts, distanceSums);           
            counts[currNode] += counts[childNode];           
            distanceSums[currNode] += (distanceSums[childNode] + counts[childNode]);
            
        }
    }
    
    
    private void preOrder(ArrayList<Integer>[] graph, int currNode, int parentNode, int[] counts, int[] distanceSums){
        for(int childNode : graph[currNode]){
            
            if(childNode == parentNode) continue;
            distanceSums[childNode] = distanceSums[currNode] + (graph.length - 2 * counts[childNode]);
preOrder(graph, childNode, currNode, counts, distanceSums);
        }
    }
}
