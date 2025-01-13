class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int bal = 0, wild = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') bal++;
                else bal--;
            } else {
                wild++;
            }
            if ((wild + bal) < 0) return false;
        }

        bal = 0;
        wild = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') bal++;
                else bal--;
            } else {
                wild++;
            }
            if ((wild + bal) < 0) return false;
        }

        return true;
    }
}
