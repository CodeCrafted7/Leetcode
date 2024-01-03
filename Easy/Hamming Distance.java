class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y, z, count = 0;
        while(temp > 0){
            if( (z = temp & 1) == 1)
                count++;
            temp = temp >>> 1;
        }       
        return count;
    }
}
