class Solution {
    public int pivotIndex(int[] nums) {
        int ls=0;
        int ts=0;
        for(int ele:nums)
         ts+=ele;
         for(int i=0;i<nums.length;ls+=nums[i++])
         {
              if(ls*2==ts-nums[i])
              return i;
         }
         return -1;
    }
}
