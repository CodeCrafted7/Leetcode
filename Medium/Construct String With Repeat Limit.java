class Solution {
    public String repeatLimitedString(String s, int limit) {
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 25;
        int back = 25;
        while (i >= 0 && back > -1) {
            int f = 0;
            i = back;
            while (f < limit && arr[i] != 0) {
                sb.append((char) (i + 'a'));
                f++;
                arr[i]--;
            }
            if(arr[i] == 0){
                back = i-1;
            }
            else{
                i--;
                while(i >= 0 && arr[i] == 0){
                    i--;
                }
                if(i != -1){
                    arr[i]--;
                    sb.append((char) (i + 'a'));
                }
                else{
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}
