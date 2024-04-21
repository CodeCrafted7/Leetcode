class Solution {
    int x1;
    int y1;
    int x2;
    int y2;
    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[][] vis = new boolean[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(!vis[i][j] && land[i][j] == 1){
                    x1 = Integer.MAX_VALUE;
                    y1 = Integer.MAX_VALUE;
                    x2 = Integer.MIN_VALUE;
                    y2 = Integer.MIN_VALUE;
                    dfs(i , j , land , vis);
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(x1);
                    a.add(y1);
                    a.add(x2);
                    a.add(y2);
                    ans.add(a);
                }
            }
        }
        int size = ans.size();
        int[][] res = new int[size][4];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < 4 ; j++){
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }
    public void dfs(int i , int j , int[][] land , boolean[][] vis){
        vis[i][j] = true;
        
        if(i < x1 || j < y1){
            x1 = i;
            y1 = j;
        }
        if(i > x2 || j > y2){
            x2 = i;
            y2 = j;
        }
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        for(int k = 0 ; k < 4 ; k++){
            if(isValid(i + dx[k] , j + dy[k] , vis , land) == true)
                dfs(i + dx[k] , j + dy[k] , land , vis);
        }
    }
    public boolean isValid(int i , int j , boolean[][] vis , int[][] land){
        int rows = land.length;
        int cols = land[0].length;
        if(i < 0 || j < 0 || i > rows - 1 || j > cols - 1)
            return false;
        if(land[i][j] != 1)
            return false;
        if(vis[i][j] == true)
            return false;
        return true;
    }
}
