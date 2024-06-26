public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        boolean divide = false;
        int result = 0, sign = 1, num = 0, preNum = 0;
        for(char c: s.toCharArray()) {
            if(c >= '0' && c <= '9')
                num = num * 10 + c -'0';
            else if(c == '+' || c == '-' || c == '*' || c == '/') {
                if(divide) {
                    num = preNum/num;
                    divide = false;
                }
                //record the temp result, think about case 2 * 5 / 2
                if(c == '/') {
                    divide = true;
                    preNum = num * sign;
                    sign = 1;
                } else if(c == '*'){
                    sign *= num;
                } else {
                    result += sign * num;
                    sign = c == '+' ? 1 : -1;
                }
                num = 0;
            }
        }
        if(num > 0) {
            if(divide)
                num = preNum/num;
            result += sign * num;
        }
        return result;
    }
}
