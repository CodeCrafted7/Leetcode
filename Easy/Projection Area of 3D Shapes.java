class Solution {
    public int projectionArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int front = 0;
            int side = 0;
            for (int j = 0; j < grid.length; j++) {
                front = Math.max(front, grid[i][j]);
                side = Math.max(side, grid[j][i]);
                result += Math.min(grid[i][j], 1);
            }
            result += front + side;
        }
        return result;        
    }
}
