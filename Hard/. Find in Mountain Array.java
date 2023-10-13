class Solution {
    public int findInMountainArray(int target, MountainArray mArr) {
        int sz = mArr.length(), left = 0, right = sz-1, peakIndx = sz-1;
        while(left < right){
            int midIndx = left + (right - left)/2;
            if(mArr.get(midIndx) < mArr.get(midIndx + 1)){
                left = midIndx + 1;
                peakIndx = midIndx + 1;
            }else{
                right = midIndx;
            }
        }
        left = 0;
        right = peakIndx ;
        while(left <= right){
            int midIndx = left + (right - left)/2;
            if(mArr.get(midIndx) < target){
                left = midIndx + 1;
            }else if(mArr.get(midIndx) > target){
                right = midIndx - 1;
            }else{
                return midIndx;
            }
        }
        left = peakIndx;
        right = sz - 1;
        while(left <= right){
            int midIndx = left + (right - left)/2;
            if(mArr.get(midIndx) > target){
                left = midIndx + 1;
            }else if(mArr.get(midIndx) < target){
                right = midIndx - 1;
            }else{ 
                return midIndx;
            }
        }
        return -1;
    }
}
