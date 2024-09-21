class Solution {
    public int solve(int arr[], String a) {
        int i = 0, j = 1;
        while (j < a.length()) {
            if (a.charAt(i) == a.charAt(j)) {
                i++;
                arr[j] = i;
                j++;
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = arr[i - 1];
                }
            }
        }
        return arr[a.length() - 1];
    }

    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String t = sb.toString();
        
        String a = s + '#' + t;
        int arr[] = new int[a.length()];
        
        int i = solve(arr, a);
        
        String temp = s.substring(i);
        
        StringBuilder tempSb = new StringBuilder(temp);
        tempSb.reverse();
        
        return tempSb.toString() + s;
    }
}
