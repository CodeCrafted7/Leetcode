class Solution {
    Map<List<Boolean>, Boolean> memo = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal)
            return true;
        int sum = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            sum += i;
        }
        if (sum < desiredTotal) return false;
        List<Boolean> taken = new ArrayList<>();
        for (int i = 0; i <= maxChoosableInteger; i++) {
            taken.add(false);
        }
        return solver(maxChoosableInteger, desiredTotal, taken);
    }

    public boolean solver(int maxChoosableInteger, int desiredTotal, List<Boolean> taken) {
        if (desiredTotal <= 0) return false;
        if (memo.containsKey(taken)) return memo.get(taken);
        for (int i = 1; i <= maxChoosableInteger; i++) { 
            if (taken.get(i)) continue;
            taken.set(i, true);
            boolean secondPersonWinOrNot = solver(maxChoosableInteger, desiredTotal - i, taken);
            taken.set(i, false);
            if (!secondPersonWinOrNot){
                memo.put(taken, true);
                return true;
            }
        }
        memo.put(taken, false);
        return false;
    }
}
