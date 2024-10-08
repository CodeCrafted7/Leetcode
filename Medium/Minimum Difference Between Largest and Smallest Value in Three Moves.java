class Solution {
    public int minDifference(int[] arr) {
        int n = arr.length;
        if(n<=4) return 0;
        Arrays.sort(arr);

        int a = arr[n-4]-arr[0];
        int b = arr[n-3]-arr[1];  
        int c = arr[n-2]-arr[2]; 
        int d = arr[n-1]-arr[3]; 

        return Math.min(a,Math.min(b,Math.min(c,d)));
        
    }
}
