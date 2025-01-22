class Solution {
    public long gridGame(int[][] grid) {
        long topSum = 0;
        int n = grid[0].length;
        for(int i=0;i<n;i++){
            topSum += grid[0][i];
        }
        long ans = Long.MAX_VALUE;
        long bottomSum = 0;

        for(int pp = 0;pp<n;pp++){
            topSum -= grid[0][pp];
            ans = Math.min(ans, Math.max(topSum,bottomSum));
            bottomSum += grid[1][pp]; 
        }
        return ans;
    }
}
