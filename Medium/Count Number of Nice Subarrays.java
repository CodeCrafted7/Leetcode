class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }

    public int atmost(int [] nums, int k){
        int i=0;
        int j=0;
        int ans=0;
        int countOdd=0;
        int n=nums.length;
        while(j<n){
            if (nums[j]%2!=0){
                countOdd++;
            }
            while(countOdd>k){
                if (nums[i]%2!=0){
                    countOdd--;
                }
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}
