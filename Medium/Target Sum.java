class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        solve(0,0,target,nums);
        return ans;
    }
    public void solve(int index,int result,int target, int [] nums){
        if(index==nums.length){
            if(result==target){
                ans++;
            }
            return;
        }
        solve(index+1,result+nums[index],target,nums);
        solve(index+1,result-nums[index],target,nums);
    }
}
