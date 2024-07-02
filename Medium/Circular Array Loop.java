class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0;i<nums.length;i++) {
            nums[i] = nums[i] % nums.length;
        }

        for (int i = 0;i<nums.length;i++) {
          
            if (nums[i]> 0 && nums[i] < nums.length && visitPositive(nums, i,i)) {
                return true;
            } else if (nums[i]< 0 && -nums[i] < nums.length && visitNegative(nums, i, i)) {
                return true;
            }
        }

        return false;


    }

    boolean visitPositive(int[] nums, int index, int startingIndex) {
        if (nums[index] % nums.length == 0) {
            
            return false;
        } else if (nums[index] <0) {
            
            return false;
        } else if (nums[index] > nums.length && nums[index] < (nums.length * (startingIndex+1))) {
        
            return false;
        } else if (nums[index] > (nums.length * (startingIndex+1))) {
          
            return true;
        }

    
        int nextIndex = (index + nums[index]) % nums.length;

        nums[index] += nums.length * (startingIndex + 1);

        return visitPositive(nums, nextIndex, startingIndex);

    }

    boolean visitNegative(int[] nums, int index,int startingIndex) {
        if (nums[index] % nums.length == 0) {
            return false;
        } else if (nums[index] >0) {
            return false;
        } else if (-nums[index] > nums.length && -nums[index] < (nums.length * (startingIndex+1))) {
            return false;
        } else if (-nums[index] > (nums.length * (startingIndex+1))) {
            return true;
        }

        int nextIndex = ((index + nums[index]) % nums.length + nums.length) % nums.length;

        nums[index] -= nums.length * (startingIndex+1);

        return visitNegative(nums, nextIndex, startingIndex);
    }
}
