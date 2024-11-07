class Solution {
    public boolean canSortArray(int[] nums) {
    int max  = nums[0],n = nums.length,bit = countbit(nums[0]),lastmax = 0;
    for(int i=1;i<n;i++){
        boolean bt = bit != countbit(nums[i]);
        if(bt) lastmax = max;
        if(nums[i]>max){
            max = nums[i];
            bit = countbit(nums[i]);
        }
        if(nums[i]<lastmax)
            return false;
    }
    return true;
    }
    
    
    public static int countbit(int n){
        int count = 0;
        while(n != 0){
            count += n % 2;
            n = n/2;
        }
        return count;
    }
}
