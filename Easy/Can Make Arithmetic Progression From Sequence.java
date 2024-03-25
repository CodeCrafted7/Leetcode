class Solution {
  public boolean canMakeArithmeticProgression(int[] arr) {
	if(arr.length == 1) return true;
	Arrays.sort(arr);        
	int cd = arr[1] - arr[0];
	for(int i = 1; i < arr.length; i++) {
		if(arr[i-1] + cd != arr[i])
			return false;
	}

	return true;
}
}
