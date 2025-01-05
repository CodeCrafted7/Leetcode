class Solution {
    public int countPalindromicSubsequence(String s) {
	int[][] bounds = new int[26][2];
	for (int i = 0; i < 26; i++) {
		bounds[i][0] = Integer.MAX_VALUE;
		bounds[i][1] = Integer.MIN_VALUE;
	}
	for (int i = 0; i < s.length(); i++) {
		int pos = s.charAt(i) - 'a';
		bounds[pos][0] = Math.min(bounds[pos][0], i);
		bounds[pos][1] = Math.max(bounds[pos][1], i);
	}
	int ans = 0;
	boolean[] seen;
	for (int i = 0; i < 26; i++) {
		seen = new boolean[26];
		for (int j = bounds[i][0] + 1; j < bounds[i][1]; j++) {
			char c = s.charAt(j);
			if (!seen[c - 'a']) {
				ans++;
				seen[c - 'a'] = true;
			}
		}
	}
	return ans;
}
}
