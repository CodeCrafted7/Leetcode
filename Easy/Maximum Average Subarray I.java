class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int w=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(i>=k-1)
            {
                max = Math.max(max,sum);
                sum-=nums[w++];
            }
        }
        return (double)max/k;
    }
}
