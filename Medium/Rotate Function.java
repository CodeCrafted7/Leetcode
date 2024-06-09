class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        int sum1=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]*i;
            sum1+=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            sum+=sum1-(n*nums[i]);
            max=Math.max(sum,max);
        }
        return max;
    }
}
