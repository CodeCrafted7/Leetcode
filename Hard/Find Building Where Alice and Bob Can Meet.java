class Solution {
    int[] heights;
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        this.heights = heights;
        int n = heights.length;
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        PriorityQueue<Integer> minIndex = new PriorityQueue<>((i,j) -> Integer.compare(minIndex(queries[i]), minIndex(queries[j])));  // sort queries by min index both can jump to
        PriorityQueue<Integer> minHeight = new PriorityQueue<>((i,j) -> Integer.compare(minHeight(queries[i]), minHeight(queries[j]))); // sort queries by lowest height both can jump to
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == queries[i][1] || heights[minIndex(queries[i])] > heights[Math.min(queries[i][0], queries[i][1])])
                ans[i] = minIndex(queries[i]); // can jump directly 
            else minIndex.offer(i);
        } 
        for (int i = 0; i < n; i++){
            while(!minIndex.isEmpty() && minIndex(queries[minIndex.peek()]) == i) minHeight.offer(minIndex.poll());
            while(!minHeight.isEmpty()){
                int[] q = queries[minHeight.peek()];
                if (minHeight(q) <= heights[i]) ans[minHeight.poll()] = i;
                else break;
            }
        }
        return ans;
    }

    private int minIndex(int[] q){
        return Math.max(q[0], q[1]);
    }
    private int minHeight(int[] q){
        return Math.max(heights[q[0]], heights[q[1]]) + 1;
    }
}
