class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0, maxi = 0;

        for (int i = 0; i < k - 1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        for (int i = k - 1; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];

            if (map.size() == k) {
                maxi = Math.max(maxi, sum);
            }

            int removeIndex = i - k + 1;
            if (map.get(nums[removeIndex]) == 1) {
                map.remove(nums[removeIndex]);
            } else {
                map.put(nums[removeIndex], map.get(nums[removeIndex]) - 1);
            }
            sum -= nums[removeIndex];
        }

        return maxi;
    }
}
