class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList();
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = new int[n],
            col[] = new int[m];
        Arrays.fill(row,Integer.MAX_VALUE); 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                row[i] = Math.min(row[i],matrix[i][j]);
                col[j] = Math.max(col[j],matrix[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==col[j])  
                ans.add(matrix[i][j]);
            } 
        }  
      return ans;
    }
}
