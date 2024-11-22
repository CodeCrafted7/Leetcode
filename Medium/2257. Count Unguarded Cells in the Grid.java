class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int mat[][] = new int[m][n];

        for(int guard[] : guards){
            mat[guard[0]][guard[1]] = 1;
        }
        for(int wall[] : walls){
            mat[wall[0]][wall[1]] = 1;
        }
        for(int guard[] : guards){
            int i = guard[0];
            int j = guard[1];
            dfs(i-1,j,mat,'L');
            dfs(i+1,j,mat,'R');
            dfs(i,j-1,mat,'U');
            dfs(i,j+1,mat,'D');
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0)
                    ans++;
            }
        }
        return ans;
    }
    
    private void dfs(int i,int j,int mat[][], char c){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j] == 1)
            return;

        mat[i][j] = 2;
        if(c == 'L') dfs(i-1,j,mat,c);
        if(c == 'R') dfs(i+1,j,mat,c);
        if(c == 'U') dfs(i,j-1,mat,c);
        if(c == 'D') dfs(i,j+1,mat,c);
    }
}
