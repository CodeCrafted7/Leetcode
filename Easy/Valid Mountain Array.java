class Solution {
    public boolean validMountainArray(int[] arr) {
        int i=0;
        if(arr.length <3) return false;
        boolean flag1 = false;
        while(i<arr.length-1 && arr[i] < arr[i+1])
        {i++;
         flag1 = true; }
        boolean flag2 = false;
        while(i<arr.length-1 && arr[i] > arr[i+1])
        {i++;
         flag2 = true;}
        if(i == arr.length-1 && flag1 == true && flag2 == true) return true;
        
        return false;
    }
}
