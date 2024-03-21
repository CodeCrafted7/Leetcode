class Solution {
    public int maxPower(String s) {
        int maxCount = 0, pointer = 0, counter = 0;
        char currChar = s.charAt(pointer);

        while (pointer < s.length()) {
            if (s.charAt(pointer) == currChar) {
                ++counter;
                maxCount = Math.max(counter, maxCount);
            } else {
                counter = 1;
                currChar = s.charAt(pointer);
            }
            ++pointer;
        }
        return maxCount;
    }
}
