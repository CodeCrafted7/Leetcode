class Solution {
    public int[] sumZero(int n) {
        final int[] answer = new int[n];
        final int halfn = n / 2;
        for (int i = 0; i < halfn; i++) {
            answer[i] = i - halfn;       
            answer[n - i - 1] = halfn - i; 
        }
        return answer;
    }

}
