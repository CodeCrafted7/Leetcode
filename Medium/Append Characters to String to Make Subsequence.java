class Solution {
    public int appendCharacters(String s, String t) {
        int n = t.length();
        int tPointer = 0;
        for (int sPointer = 0; sPointer < s.length(); sPointer++) {
            if (tPointer < n && s.charAt(sPointer) == t.charAt(tPointer)) {
                tPointer++;
            }
        }
        return n - tPointer;
    }
}
