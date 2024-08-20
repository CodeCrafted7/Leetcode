class Solution {
    public int minSteps(int n) {
        int curr=1,ans=0,buff=0;
        while(curr<n){
            int rest = n-curr;
            if(rest % curr == 0){
                buff = curr;
                curr += buff;
                ans +=2;
            }
            else{
                curr +=buff;
                ans++;
            }
        }
        return ans;
    }
}
