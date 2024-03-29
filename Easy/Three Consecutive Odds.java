class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int mul;
        for (int i = 0; i < arr.length - 2; i++) {
            mul = arr[i] * arr[i + 1] * arr[i + 2];
            if (mul % 2 == 1)
                return true;
        }
        return false;
    }

}
