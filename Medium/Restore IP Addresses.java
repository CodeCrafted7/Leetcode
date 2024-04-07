class Solution {
   public List<String> restoreIpAddresses(String s) {
	List<String> result = new ArrayList<>();
	if (s == null || s.length() == 0 || s.length() > 12) return result;
	restoreIpAddressesHelper(s, 0, 0, new StringBuilder(), result);
	return result;
}
    
private void restoreIpAddressesHelper(String s, int index, int count, 
	StringBuilder sb, List<String> result) {
	if (index == s.length() && count == 3) {
		result.add(sb.toString());
		return;
	}
	if (count > 3) return;

	for (int i = index; i < s.length(); i++) {
		String part = s.substring(index, i + 1);

		if (part.length() == 0 || part.length() > 1 && part.charAt(0) == '0' || 
		   Integer.valueOf(part) > 255) break; 
		int len = sb.length();
		sb.append(part);
		if (i + 1 == s.length())
			restoreIpAddressesHelper(s, i + 1, count, sb, result);
		else {
			sb.append("."); 
			restoreIpAddressesHelper(s, i + 1, count + 1, sb, result);
		}		
		sb.setLength(len);
	}        
}
}
