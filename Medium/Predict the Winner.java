class Solution {
    public boolean predictTheWinner(int[] nums) {
        return rec(nums,0,nums.length-1)>=0;
    }
    public static int rec(int nums[],int s,int e){
        if(s==e)
            return nums[e];
        int l = nums[s] - rec(nums,s+1,e); 
        int r = nums[e] - rec(nums,s,e-1);
        return Math.max(l,r); 
    }
}
