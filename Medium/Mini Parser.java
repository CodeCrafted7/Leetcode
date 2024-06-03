/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '['){
                NestedInteger temp = new NestedInteger();
                stack.offerFirst(temp);
            }
            else if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '-'){
                int start = i;
                while(start < s.length() && s.charAt(start) != ',' && s.charAt(start) != ']'){
                    start++;
                }
                String str = s.substring(i, start);
                int value = Integer.parseInt(str);
                NestedInteger top = stack.pollFirst();
                NestedInteger num = new NestedInteger(value);
                if(top == null){
                    top = num;
                }
                else{
                    top.add(num);
                }
                stack.offerFirst(top);
                i = start - 1;
            }
            else if(s.charAt(i) == ']'){
                NestedInteger temp = stack.peekFirst();
                if(stack.size() > 1){
                    stack.pollFirst();
                    NestedInteger next = stack.pollFirst();
                    next.add(temp);
                    stack.offerFirst(next);
                }
            }
        }
        return stack.peekFirst();
    }
}
