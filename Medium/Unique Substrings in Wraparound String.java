class Solution {
    public int findSubstringInWraproundString(String s) {
        int count = 0;
        char prev = '\0';
        int[] longest = new int[26];
        for (char c : s.toCharArray()) {
            if (c - prev == 1 || c == 'a' && prev == 'z') {
                ++count;
            } else {
                count = 1;
            }
            longest[c - 'a'] = Math.max(longest[c - 'a'], count);
            prev = c;
        }

        int ans = 0;
        for (int n : longest) ans += n;
        return ans;
    }
}
