class Solution {
    public int atMostSum(int[] nums, int goal){

        int si=0, ei=0, sum=0, totalSubArray=0, n=nums.length;

        while(ei < n) {
            sum+=nums[ei++];

            while(sum > goal){
                sum-=nums[si++];
            }
            totalSubArray+=ei-si;
        }
        return totalSubArray;
        
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostSum(nums, goal) - (goal - 1 > -1 ? atMostSum(nums, goal - 1) : 0);
     }
}
