class Solution {
    public int minimumLength(String s) {
        int freq[]  = new int[26];
        int n = s.length();
        int ans = 0;

        for(int i=0;i<n;i++)
            freq[s.charAt(i) - 'a']++;

        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                if(freq[i]%2 == 0)  ans += 2;
                else ans += 1;
            }
        }
        return ans;
    }
}
