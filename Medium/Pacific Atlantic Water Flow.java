class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int rowDash[] = { -1, 0, 1, 0 };
    int colDash[] = { 0, 1, 0, -1 };
    boolean Dp[][];

    boolean bfs_and_Check(int r, int c, int m, int n, int[][] heights) {
        Queue<Pair> Q = new LinkedList<>();
        boolean Visited[][] = new boolean[m][n];
        Q.add(new Pair(r, c));
        Visited[r][c] = true;

        boolean pacific = false;
        boolean atlantic = false;

        while (!Q.isEmpty()) {
            Pair rem = Q.remove();
            int currRow = rem.row;
            int currCol = rem.col;
           

            if (currRow == 0 || currCol == 0) {
                pacific = true;
            }
            if (currRow == m - 1 || currCol == n - 1) {
                atlantic = true;
            }
            if (pacific == true && atlantic == true) {
                // Dp[r][c] = true;
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int adjRow = currRow + rowDash[i];
                int adjCol = colDash[i] + currCol;
                if (adjRow >= 0 && adjCol >= 0 && adjRow < m && adjCol < n && Visited[adjRow][adjCol] == false
                        && heights[adjRow][adjCol] <= heights[currRow][currCol]) {
                            // System.out.println("Row  col"+adjRow+"   "+adjCol);
                    Visited[adjRow][adjCol] = true;
                    Q.add(new Pair(adjRow, adjCol));
                }
            }

        }
        return false;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> Ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        // System.out.println(bfs_and_Check(2,3,m,n,heights));

        Dp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == n - 1) || (i == m - 1 && j == 0)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    Ans.add(list);
                    continue;
                } else {
                    boolean canTouchPacificAndAtlantic = bfs_and_Check(i, j, m, n, heights);
                    if (canTouchPacificAndAtlantic) {
                        List<Integer> list2 = new ArrayList<>();
                        list2.add(i);
                        list2.add(j);
                        Ans.add(list2);
                    }
                }
            }
        }
        return Ans;
    }
}
