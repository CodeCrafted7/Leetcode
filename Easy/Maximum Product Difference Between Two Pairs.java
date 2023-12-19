class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ab = nums[0] * nums[1];
        int cd = nums[n-1] * nums[n-2];
        return cd - ab;    
    }
}
