import java.util.*;

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        char c1, c2;
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        if (y > x) {
            c1 = 'a';
            c2 = 'b';
        }else {
            c1 = 'b';
            c2 = 'a';
        }
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == c1 && stack.peek() == c2) {
                ans += max;
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (stack2.isEmpty()) {
                stack2.push(sb.charAt(i));
                continue;
            }
            if (sb.charAt(i) == c2 && stack2.peek() == c1) {
                ans += min;
                stack2.pop();
            }else {
                stack2.push(sb.charAt(i));
            }
        }
        return ans;
    }
}
