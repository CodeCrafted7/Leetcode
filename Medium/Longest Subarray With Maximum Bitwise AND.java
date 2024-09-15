class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int ans = 0,len = 0;
        for(int n : nums)
            maxi = Math.max(maxi,n);

        for(int x : nums){
            if(maxi == x)
                ans = Math.max(ans,++len);
            else
                len = 0;
        }
        return ans;
    }
}
