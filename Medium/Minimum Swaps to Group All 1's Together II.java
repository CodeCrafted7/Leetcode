class Solution {
    public int minSwaps(int[] nums) {
        int ws = 0;
        int cz=0;
        for(int num : nums)
            ws+=num;
        for(int i=0;i<ws;i++){
            if(nums[i]==0)
                cz++;
        }
        int mz = cz;
        int s = 0;
        int e = ws-1;
        int n = nums.length;
        while(s<n){
            if(nums[s]==0)
                cz--;
            s++;
            e++;
            if(nums[e%n]==0)
                cz++;
            mz = Math.min(mz,cz);
        }
        return mz;
    }
}
