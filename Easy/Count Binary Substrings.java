class Solution {
  public int countBinarySubstrings(String s) {
	int curCountOfOneOrZero = 1;
	int prevCountOfOneOrZero = 0;
	int binaryStrCount = 0;
	for (int i = 1; i < s.length(); i++) {
		if (s.charAt(i) == s.charAt(i - 1)) {
			curCountOfOneOrZero++;
		} else {
	
			prevCountOfOneOrZero = curCountOfOneOrZero;
			curCountOfOneOrZero = 1;
		}
		if (prevCountOfOneOrZero >= curCountOfOneOrZero) {
			binaryStrCount++;
		}
	}
	return binaryStrCount;
}
}
