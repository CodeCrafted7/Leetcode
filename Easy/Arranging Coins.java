class Solution {
    public int arrangeCoins(int n) {
        int coins = 0, complete = 0;

        while (true) {
            if (++coins <= n) {
                n -= coins;
                complete++;
            }
            else break;
        }

        return complete;
    }
}
