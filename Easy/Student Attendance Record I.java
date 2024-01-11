class Solution {
    public boolean checkRecord(String s) {
         return s.indexOf("A")==s.lastIndexOf("A") && s.indexOf("LLL") == -1;
    }
}
