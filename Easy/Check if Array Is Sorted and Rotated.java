class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            // More than 1 inversion means it's not sorted and rotated
            if (count > 1) return false; 
        }
        
        return true;
    }
}s
