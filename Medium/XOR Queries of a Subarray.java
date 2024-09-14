class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int x[] = new int[n+1];

        for(int i=1;i<n+1;i++)
            x[i] = x[i-1] ^ arr[i-1];

        int res[]  = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            res[i] = x[queries[i][0]] ^ x[queries[i][1]+1];
        }
        return res;
    }
}
