class Solution {
    public int surfaceArea(int[][] grid) {
        int area=0;
        int len = grid.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                area += grid[i][j]>0 ? 4*grid[i][j] + 2:0;
            }
        }

        for(int i=0; i<len; i++){
            for(int j=0; j<len-1; j++){
                area -= 2*Math.min(grid[i][j], grid[i][j+1]);
            }
        }

        for(int j=0; j<len; j++){
            for(int i=0; i<len-1; i++){
                area -= 2*Math.min(grid[i][j], grid[i+1][j]);
            }
        }

        return area;
    }
}
