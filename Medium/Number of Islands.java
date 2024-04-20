class Solution {
     public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfsMark(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void dfsMark(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;
        if (grid[i][j] != '1') return;
        
        grid[i][j] = 'X';
        dfsMark(grid, i, j + 1);
        dfsMark(grid, i + 1, j);
        dfsMark(grid, i, j - 1);
        dfsMark(grid, i - 1, j);
    }
}
