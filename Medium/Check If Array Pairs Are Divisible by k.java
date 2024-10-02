class Solution {
    public boolean canArrange(int[] arr, int k) {
       int ans[] = new int[k];
       int n = arr.length;

       for(int i=0;i<n;i++){
            int rem = ((arr[i] % k) + k) % k;
            ans[rem]++;
       }

       if(ans[0] % 2 != 0) return false;

        for(int i=1; i<=k/2 ;i++){
            int comp = k-i;
            if(ans[i] != ans[comp]) return false;
        }
        return true;
    }
}
