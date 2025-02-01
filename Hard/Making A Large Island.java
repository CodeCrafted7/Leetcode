class Solution {
    int[][][] dp;
    int m ;
    int n ;
    int[][] grid;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int largestIsland(int[][] g) {
        grid = g;
         m = grid.length;
         n = grid[0].length;
        dp = new int[m][n][2];
        int max = 0;
        int curr =1 ; 
        for (int i = 0 ;i<m;i++){
            for (int j = 0 ;j<n;j++){
                int count = -1;
                if (grid[i][j]==1 && dp[i][j][0]==0){
                    count = dfs1 (i,j,curr);
                    dfs2(i,j,count);
                    curr++;
                }
                
            }
        }
        for (int i = 0 ;i<m;i++){
            for (int j = 0 ;j<n;j++){
                if (grid[i][j]==0){
                    int res = 1;
                    HashSet<Integer> set=new HashSet<>();
                    for (int[] ele : dir){
                        int ni = i+ele[0];
                        int nj = j+ele[1];
                        if (valid (ni,nj) && !set.contains(dp[ni][nj][0])){
                             res+=dp[ni][nj][1];
                             set.add(dp[ni][nj][0]);
                        }
                    }
                    max = Math.max(max,res);
                }
            }
        }
        return max==0?m*n:max;
    }
    boolean valid (int ni , int nj ){
        return (ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==1);
    }
    int dfs1(int i , int j , int curr){
        if (dp[i][j][0]!=0){
            return 0;
        }
        else {
            dp[i][j][0]=curr;
            int res = 1;
            for (int [] ele : dir){
                int ni = i+ele[0];
                int nj = j+ele[1];
                if (valid(ni,nj) && dp[ni][nj][0]==0){
                    res+=dfs1(ni,nj,curr);
                }
            }
            return res;
        }
    }
    void dfs2 (int i , int j,int val){
        
        if (dp[i][j][1]==0) {
            dp[i][j][1]=val;
            for (int [] ele : dir){
                int ni = i+ele[0];
                int nj = j+ele[1];
                if (valid(ni,nj) && dp[ni][nj][1]==0){
                    dfs2(ni,nj,val);
                }
            }
             
        }
    }
}
