class Solution {
    
    void swap(int[] A, int i, int j){
         int tmp = A[i];
         A[i] = A[j];
         A[j] = tmp;
    }
    
    public int[] sortArrayByParityII(int[] A) {
        int odd_p = 1;
        int n = A.length;
        
        for(int i=0;i<n;i+=2){
            if(A[i]%2 == 1){
                while(A[odd_p]%2 == 1)
                    odd_p += 2;
                swap(A, i, odd_p);
            }
        }
        
        return A;
    }
}
