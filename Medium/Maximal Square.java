class Solution {
    Integer[][]c;
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int res=Integer.MIN_VALUE;
        c=new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    res=Math.max(res,dfs(matrix,i,j));
                }
            }
        }
        return res*res;
        
    }
    public int dfs(char[][]matrix,int i,int j){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length  || matrix[i][j]=='0') return 0;
        if(c[i][j]!=null) return c[i][j];
        return c[i][j]=1+Math.min(Math.min(dfs(matrix,i+1,j),dfs(matrix,i,j+1)),dfs(matrix,i+1,j+1));
        
    }
}
