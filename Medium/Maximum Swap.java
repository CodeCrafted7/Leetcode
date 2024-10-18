class Solution {
    public int maximumSwap(int num) {
        char arr[] = Integer.toString(num).toCharArray();
        int n = arr.length;
        char maxe  = arr[n-1];
        int maxi = n-1;
        int i1 = -1;
        int i2 = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] > maxe){
                maxe = arr[i];
                maxi = i;
            }else if(arr[i] < maxe){
                i1 = i;
                i2 = maxi;
            }
        }
        if(i1 != -1){
            char temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }
        return Integer.parseInt(new String(arr));
    }
}
