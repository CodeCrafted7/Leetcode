class Solution {
    public int minimumPushes(String word) {
        int arr[] = new int[26];
        int count = 0,minkp =0;
        for(char ch : word.toCharArray()){
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
        for(int i=25;i>=0;i--){
            if(arr[i]==0) break;
            int val = arr[i]*(count/8+1);
            minkp += val;
            count++;
        }
        return minkp;
    }
}
