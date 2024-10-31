class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n];
        int[] desc = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            desc[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    desc[i] = Math.max(desc[i], desc[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            if (inc[i] > 1 && desc[i] > 1)
                max = Math.max(max, inc[i] + desc[i] - 1);
        }
        return n - max;
    }
}
