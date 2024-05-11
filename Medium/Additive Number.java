class Solution {
   public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() <= 2) return false;
        for (int i = 0; i < (num.length() - 1) / 2; i++) {
            for (int j = i + 1; num.length() - j - 1 >= Math.max(i + 1, j - i); j++) {
                if (isValid(num.substring(0, i + 1), num.substring(i + 1, j + 1), num.substring(j + 1)))
                    return true;
            }
        }
        return false;
    }

    public boolean isValid(String num1, String num2, String remain) {
        if (remain.isEmpty()) return true;
        if (num1.charAt(0) == '0' && num1.length() > 1) return false;
        if (num2.charAt(0) == '0' && num2.length() > 1) return false;
        String sum = String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
        if (!remain.startsWith(sum)) return false;
        return isValid(num2, sum, remain.substring(sum.length()));
    }
}
