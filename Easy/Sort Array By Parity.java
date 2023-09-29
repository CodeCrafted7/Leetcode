class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int temp=0;
        while(i<j)
        {
            if(nums[i]%2>nums[j]%2)
            { temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        if(nums[i]%2==0)i++;
        if(nums[j]%2==1)j--;
        }
       
        return nums;
    }
}
