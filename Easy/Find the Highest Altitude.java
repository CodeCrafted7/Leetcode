class Solution {
    public int largestAltitude(int[] gain) {
        int c=0;
        int max=0;
        for(int i :gain){
            c+=i;
            max = Math.max(max,c);
        }
        return max;
    }
}
