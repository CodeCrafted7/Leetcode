class Solution {
 public int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    int[][] result = new int[nums.length / 3][3];
    
    for (int index = 1; index < nums.length; index = index + 3) {
      int previous = nums[index - 1], current = nums[index], next = nums[index + 1];

      if (next - previous > k)
        return new int[][]{};
      else 
        result[index / 3] = new int[]{previous, current, next};
    }
    return result;
  }
}
