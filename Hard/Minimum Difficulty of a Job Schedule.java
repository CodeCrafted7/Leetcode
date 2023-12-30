class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int leng =  jobDifficulty.length;
        if (leng < d) return -1;
        int[][] dp = new int[d][leng]; 
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < leng; i++) { 
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1 ; i < d; i++) { 
            for (int j = i; j < leng; j++) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = j; k >= i; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    min = Math.min(min, dp[i - 1][k - 1] + max);
                }
                dp[i][j] = min;
            }
        }
        return dp[d - 1][leng - 1];   
    }
}
