class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] arr = new long[n];
        for(int i = 0; i<roads.length; i++){
            for(int j = 0; j<2; j++){
                int freq = roads[i][j];
                arr[freq]++;
            }
        }
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(long i: arr){
            pq.add(i);
        }
        int k = n;
        long sum = 0;
        while(k!=0){
            sum += (k*pq.poll()); 
            k--;
        }
        return sum;
    }
}
