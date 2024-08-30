class Solution {
    public static void dfs(int i,int vis[],int stones[][],int n){
        vis[i] = 1;
        for(int j=0;j<n;j++){
            if(vis[j] == 0){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    dfs(j,vis,stones,n);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int vis[] = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
        if(vis[i] == 0){
            dfs(i,vis,stones,n);
            ans++;
            }
        }
        return n-ans;
    }
}
