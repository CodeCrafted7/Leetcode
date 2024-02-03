class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] output = new int[n];
        int cPosition = -n;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == c){
                cPosition = i;
            }
            output[i] = i-cPosition;
        }

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == c){
                cPosition = i;
            }
            output[i] = Math.min(output[i], Math.abs(i - cPosition));
        }
        return output;
    }
}
