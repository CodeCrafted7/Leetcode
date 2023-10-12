class Solution {
    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    infect(grid, i, j);
                }
            }
        }

        int minInfectingTime = 2;
        for (int[] row : grid) {
            for (int rottenOrange : row) {
                if (rottenOrange == 1) return -1;
                if (rottenOrange > minInfectingTime) minInfectingTime = rottenOrange;
            }
        }

        return minInfectingTime - 2;
    }

    private void infect(int[][] grid, int i, int j) {
        int CONFIRMED_PATIENT = grid[i][j];

        if ((i > 0) && (grid[i-1][j] == 1 || grid[i-1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i-1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i-1, j);
        }

        if ((j > 0) && (grid[i][j-1] == 1 || grid[i][j-1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j-1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j-1);
        }

        if ((i + 1 < grid.length) && (grid[i+1][j] == 1 || grid[i+1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i+1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i+1, j);
        }

        if ((j + 1 < grid[0].length) && (grid[i][j+1] == 1 || grid[i][j+1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j+1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j+1);
        }
    }
}
