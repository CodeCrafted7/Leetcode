class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int k=n>>1;
        int m=(n^(k));
        if((m&(m+1))==0)
        return true;

        return false;

    }
}
