class Solution {
    private void reverse(char[] arr,int i,int j){
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public String reverseStr(String s, int k) {
        char[] arr=s.toCharArray();
        int n=arr.length,i=0;
        while(i<n){
                reverse(arr,i,Math.min(i+k-1,n-1));
                i+=2*k;
        }
        return new String(arr);
    }
}
