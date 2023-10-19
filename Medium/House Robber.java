class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
    public static int solve(int i,int[] nums,int dp[]){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1)return dp[i];
        int left=0;
        int right=0;
        if(i<nums.length)
       left= nums[i]+solve(i+2,nums,dp);
       if(i+1<nums.length)
         right=nums[i+1]+solve(i+3,nums,dp);
        return dp[i]=Math.max(left,right);
}
}
