class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }
        int x = kthGrammar(n-1,(k+1)/2);
        if((x + k)%2 == 0)
            return 1;
        else
            return 0;
    }
}
