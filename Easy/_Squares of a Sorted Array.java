class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] answer = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        
        while (k >= 0) {
            if (Math.abs (nums[i]) > Math.abs (nums[j])) {
                answer[k--] = nums[i] * nums[i++];
            }
            else {
                answer[k--] = nums[j] * nums[j--];
            }
        }
        
        return answer;
    }
}
