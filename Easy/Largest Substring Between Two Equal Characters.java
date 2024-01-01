class Solution {
 public int maxLengthBetweenEqualCharacters(String s) {
        int count = 0;
    	 int ans = -1;
    	 for (int i = 0; i < s.length()-1; i++) {
			for (int j = i+1; j < s.length(); j++) {
				if(s.charAt(i)==s.charAt(j)) {
					count = j-i-1;
					if(ans<count) {
						ans = count;
					}
				}
			}
		}
		return ans;
    }
}
