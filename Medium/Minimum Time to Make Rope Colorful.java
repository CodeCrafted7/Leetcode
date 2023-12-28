class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] col = colors.toCharArray();
        int n=neededTime.length,i=0,res=0,prevT=0;
        char prevCol='#';
        for(char ch: col){
            if(ch==prevCol){
                res+=Math.min(prevT,neededTime[i]);
                prevT=Math.max(prevT,neededTime[i]);
            }else{
                prevCol=ch;
                prevT=neededTime[i];
            }
            i++;
        }
        return res;
    }
}
