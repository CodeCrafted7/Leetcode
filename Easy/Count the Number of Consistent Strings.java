class Solution {
    public int findconsistent(int arr[],String s){
        int flag = 1;
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==0){
                flag = 0;
                break;
            }
        }
        return flag;
    }
    public int countConsistentStrings(String allowed, String[] words) {
        int arr[] = new int[26];
        for(char i : allowed.toCharArray())
            arr[i-'a'] = 1;
        int count = 0;
        for(String s: words){
            count += findconsistent(arr,s);
        }
        return count;
    }
}
