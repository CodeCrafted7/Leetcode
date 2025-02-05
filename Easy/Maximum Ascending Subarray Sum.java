class Solution {
    public int maxAscendingSum(int[] nums) {
        int n  = nums.length;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        if(n == 1)
            return nums[0];
        for(int i=0;i<n;i++){
            sum = nums[i];
            int j = i+1;
            
            while(j<n){
                if(nums[j-1] < nums[j]){
                    sum += nums[j];
                    ans = Math.max(ans, sum);
                    j++;
                }else{
                    ans = Math.max(ans, sum);
                    break;
                }
            }
            i = j-1;
        }
        return ans;
    }
}
