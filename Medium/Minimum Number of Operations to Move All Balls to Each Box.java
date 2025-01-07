class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int pre = 0, post = 0, now = 0;

    
        for (int i = 0; i < n; i++) {
            now += pre;
            prefix[i] = now;
            if (boxes.charAt(i) == '1') pre++;
        }

        now = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            now += post;
            postfix[i] = now;
            if (boxes.charAt(i) == '1') post++;
        }

        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] + postfix[i];
        }
        return result;
    }
}
