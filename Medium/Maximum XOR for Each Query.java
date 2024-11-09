class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        int n = nums.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            xor ^= nums[i];
        }
        int mask = ((1 << maximumBit) -1);
        for(int i=0;i<n;i++){
            int ans =xor ^ mask;
            res[i] = ans;
            xor ^= nums[n-i-1];
        }
        return res;
    }
}
