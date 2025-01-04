class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        long forwardSum = 0;
        long backwardSum = 0;
        long[] prefixSum = new long[n];

       
        for(int i = 0; i < n; i++) {
            forwardSum += nums[i];

            prefixSum[i] = forwardSum;
        }
        for(int i = n - 1; i > 0; i--) {
            backwardSum += nums[i];

            if(prefixSum[i - 1] >= backwardSum) {
                count++;
            }
        }

        return count;
    }
}
