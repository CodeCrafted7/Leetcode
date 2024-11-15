class Solution {

    boolean possibleToDistribute(int m,int q[],int n){
        for(int x : q){
            n -= (x + m-1)/m; // ceil efficient code 
            if(n<0) return false;
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] q) {
        int l = 1;
        int maxi = Integer.MIN_VALUE;
        for(int x : q)
            maxi = Math.max(maxi , x);
        
        int r = maxi;
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(possibleToDistribute(mid,q,n)){
                ans = mid;
                r = mid-1;
            }else
                l = mid+1;
        }
        return ans;
    }
}
