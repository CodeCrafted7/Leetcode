class Solution {
    public int fib(int n) {
        return dp(n);
    }
    public int memo(int n, int dp[]){
        if(n==1 || n==0)return n;
        if(dp[n]!=-1)return dp[n];
        dp[n]=memo(n-1,dp) + memo(n-2,dp);
        return dp[n];
    }
    public int dp(int n){
        if(n==0)return 0;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2; i<=n; i++)
            dp[i]=dp[i-1]+dp[i-2];
        
        return dp[n];
    }
}
