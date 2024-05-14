class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int nrows = dungeon.length;
        int ncols = dungeon[0].length;
        int[][] dp = new int[nrows+1][ncols+1];
        for(int[] r:dp){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        dp[nrows-1][ncols] = dp[nrows][ncols-1] = 1;
        for(int r=nrows-1;r>=0;r--){
            for(int c=ncols-1;c>=0;c--){
                dp[r][c] = Math.max(1, Math.min(dp[r+1][c], dp[r][c+1])-dungeon[r][c]);
            }
        }
        return dp[0][0];
    }
}
