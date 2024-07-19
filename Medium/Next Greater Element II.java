class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nxtG = new int[arr.length];
        for (int i = 2 * arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % arr.length]){
                stack.pop();
            }
            if(i < arr.length){
                if(!stack.isEmpty()){
                    nxtG[i] = stack.peek();
                }else {
                    nxtG[i] = -1;
                }
            }
            stack.push(arr[i % arr.length]);
        }
        return nxtG;
    }
}
