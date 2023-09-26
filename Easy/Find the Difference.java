class Solution {
    public char findTheDifference(String s, String t) {
       int a=0;
        int b=0;
        for(char c:s)
         a+=c;
        for(char c:t)
        b+=c;
        return b-a;
    }
}
