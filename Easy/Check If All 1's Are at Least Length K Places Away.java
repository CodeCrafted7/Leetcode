class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last=-1;
        for(int i=0;i < nums.length;i++)
            if(nums[i]==1){
                if(i-last-1 < k && last != -1)
                    return false;
                last=i;
            }
        return true;
    }
}