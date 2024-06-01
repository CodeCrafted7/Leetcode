class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];
        }
        int posOfSetBit = findSetBitPosition(xor);
        int ans1 = 0, ans2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(checkBit(nums[i], posOfSetBit)){
                ans1 = ans1 ^ nums[i];
            }else{
                ans2 = ans2 ^ nums[i];
            }
        }
        int[] ans = {ans1, ans2};
        return ans;
    }

    public int findSetBitPosition(int xor){
        int pos = 0;
        while(pos < 32){
            if(checkBit(xor, pos)){
                return pos;
            }else{
                pos++;
            }
        }
        return pos;
    }
    public boolean checkBit(int val, int pos){
        return (val & (1 << pos)) > 0 ? true : false;
    }
}
