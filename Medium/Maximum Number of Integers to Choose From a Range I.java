class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        int num = 0, sum = 0;

        for (int x : banned) {
            bannedSet.add(x);
        }

        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i) && sum + i <= maxSum) {
                sum += i; 
                num++;    
            }
        }
        return num; 
    }
}
