class Solution {
      public static int getWinner(int[] arr, int k) {
        int n = arr.length;
        int curFirst = arr[0], curCount = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < curFirst) {
                if (++curCount == k) return curFirst;
            } else {
                curFirst = arr[i];
                curCount = 1;
                if (curCount == k) return curFirst;
            }
        }
        return curFirst;
    }
}
