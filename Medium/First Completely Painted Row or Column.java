class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,int[]> map = new HashMap<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];

        for(int i=0;i<arr.length;i++){
            int pair[] = map.get(arr[i]);
            int x = pair[0];
            int y = pair[1];

            row[x]++;
            col[y]++;

            if(row[x] == mat[0].length || col[y] == mat.length)
                return i;
        }
        return 0;
    }
}
