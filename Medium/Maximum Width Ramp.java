class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] maxi = new int[n];
        maxi[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            maxi[i] = Math.max(maxi[i+1], nums[i]);
        }
        
        int left = 0, right = 0, ans = 0;
        while (right < n) {
            if (nums[left] <= maxi[right]) {
                ans = Math.max(ans, right - left);
                right++;
            } else {
                left++;
            }
        }
        return ans;
    }
}
