class Solution {
    public int bs(int arr[],int x){
        int s = 0;
        int e = arr.length-1;
        int ans = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid] < x){
                ans = mid;
                s = mid+1;
            }
            else
                e = mid -1;
        }
        return ans;
    }
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int min = nums[0]-k;
        int max = nums[nums.length-1] +k;
        for(int i=min;i<=max;i++){
            int l = bs(nums,i-k);
            int r = bs(nums,i+k+1);
            ans = Math.max(ans,r-l);
        }
        return ans;
    }
}
