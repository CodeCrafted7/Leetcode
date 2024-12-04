class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder(s);
        int len = 0;

        for(int i=0;i<spaces.length;i++){
            if(i == 0){
                str.insert(spaces[i],' ');
                len++;
            }
            else{
                str.insert(spaces[i]+len,' ');
                len++;
            }
        }

        return str.toString();
    }
}
