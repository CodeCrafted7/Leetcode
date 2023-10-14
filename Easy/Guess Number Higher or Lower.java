public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (guess(n) == 0) return n;
        if (guess(1) == 0) return 1;
        int right = n - 1, left = 2;
        n /= 2;
        while (guess(n) != 0) {
            int g = guess(n);
            if (g > 0) {
                left = n;
                n = right - (right - n) / 2;
            } else {
                right = n;
                n = left + (n - left) / 2;
            }
        }
        return n;
    }
}
