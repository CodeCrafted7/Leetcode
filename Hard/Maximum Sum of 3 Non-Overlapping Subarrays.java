class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sol = new int[3];
        int[] arr = new int[n - k + 1];
        int curSum = 0;

        for(int i=0;i<n;i++){
            curSum += nums[i];
            if(i >= k-1){
                arr[i-k+1] = curSum;
                curSum -= nums[i-k+1];
            }
        }

        int[][] lmax = new int[n-k+1][2];
        int[][] rmax = new int[n-k+1][2];

        lmax[0][0] = arr[0];
        lmax[0][1] = 0;
        rmax[n-k][0] = arr[n-k];
        rmax[n-k][1] = n-k;

        for(int i=1;i<=n-k;i++){
            if(arr[i] > lmax[i-1][0]){
                lmax[i][0] = arr[i];
                lmax[i][1] = i;
            }else{
                lmax[i][0] = lmax[i-1][0];
                lmax[i][1] = lmax[i-1][1];
            }

            if(arr[n-k-i] >= rmax[n-k-i+1][0]){
                rmax[n-k-i][0] = arr[n-k-i];
                rmax[n-k-i][1] = n-k-i;
            }else{
                rmax[n-k-i][0] = rmax[n-k-i+1][0];
                rmax[n-k-i][1] = rmax[n-k-i+1][1];
            }
        }

        int maxSum = 0;

        for(int i=k;i<=n-k-k;i++){
            curSum = arr[i] + lmax[i-k][0] + rmax[i+k][0];
            if(curSum > maxSum){
                maxSum = curSum;
                sol[0] = lmax[i-k][1];
                sol[1] = i;
                sol[2] = rmax[i+k][1];
            }
        }

        return sol;
    }
}
