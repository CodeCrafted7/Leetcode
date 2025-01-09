class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int c = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isps(words[i], words[j]))
                    c++;
            }
        }
        return c;
    }
            
    public boolean isps(String str, String str2) {
    int n = str.length();
    int m = str2.length();

    if (n > m)
        return false;
        
        return str2.startsWith(str) && str2.endsWith(str);
    }
}
