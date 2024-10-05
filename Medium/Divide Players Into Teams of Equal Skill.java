class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length, i = 1, j = n-2;
        long sum = skill[0]+skill[n-1];
        long prod = skill[0]*skill[n-1];
        
        while (i < j) {
            if (sum != skill[i]+skill[j]) {
                return -1;
            } else {
                prod += (skill[i] * skill[j]);
            }
            i++; j--;
        }
        return prod;
    }
}
