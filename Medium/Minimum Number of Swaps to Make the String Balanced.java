class Solution {
    public int minSwaps(String s) {
        int open = 0, ub = 0;
        for(char c : s.toCharArray()){
            if(c == '[') open++;
            else if(open>0) open--;
            else ub++;
        }
        return (ub+1)/2;
    }
}
