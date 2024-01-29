class Solution {

    private final int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    private final int[][] nChooseKCache = new int[32][32];

    private int nChooseK(int n, int k) {
        if (n < 0 || k < 0) {
            return 0;
        }
        k = Math.min(k, n - k); // C(n, k) = C(n, n - k)
        if (k == 0 || k == n) {
            return 1;
        }
        if (nChooseKCache[n][k] != 0) {
            return nChooseKCache[n][k];
        }
        nChooseKCache[n][k] = nChooseK(n - 1, k - 1) + nChooseK(n - 1, k);
        return nChooseKCache[n][k];
    }

    private boolean isPrime(int number) {
        int i = 0;
        while (primes[i] < number) {
            i++;
        }
        return primes[i] == number;
    }

    private int primeBitNumbersCount(int number) {
        int length = (int) (Math.log(number) / Math.log(2));
        int pointer = 1 << length;
        int setBitsCount = 0;
        int primeBitsNumbersCount = 0;

        while (pointer != 0) {
            if ((number & pointer) > 0) {
                for (int i = 0; i < primes.length && primes[i] - setBitsCount <= length; i++) {
                    primeBitsNumbersCount += nChooseK(length, primes[i] - setBitsCount);
                }
                setBitsCount++;
            }
            pointer >>>= 1;
            length--;
        }

        if (isPrime(setBitsCount)) {
            primeBitsNumbersCount++;
        }

        return primeBitsNumbersCount;
    }

    public int countPrimeSetBits(int left, int right) {
        return primeBitNumbersCount(right) - primeBitNumbersCount(left - 1);
    }
}
