class Solution {
    public static int rr(int n,int k){
        if(n==1) return 0;
        return (rr(n-1,k)+k)%n;
    }
    public int findTheWinner(int n, int k) {
        int ans = rr(n,k)+1;
        return ans;
    }
}
