class Solution {
    public int hIndex(int[] citations) {
       int count =1;
         int h=0;
       for(int i=citations.length-1;i>=0;i--){
           if(citations[i]>=count) h++;
           else break;
           count++;
       }
       return h;  
    }
}
