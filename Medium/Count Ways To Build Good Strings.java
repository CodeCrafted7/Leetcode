class Solution {
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high+1];
        Arrays.fill(dp,-1);

        return count(low,high,zero,one,0,dp) % mod;
    }

    private int count(int low,int high,int zero,int one,int len,int dp[]){
        if(len > high) return 0;
        if(dp[len] != -1) return dp[len];
        
        int ans = ((count(low,high,zero,one,len+zero,dp) % mod) + 
                   (count(low,high,zero,one,len+one,dp) % mod) ) % mod;
        
        
        if(len >= low && len <= high) ans += 1;
        return dp[len] = ans % mod;
    }
}
