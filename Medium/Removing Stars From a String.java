class Solution {
    public String removeStars(String s) {       
        StringBuilder ans = new StringBuilder();
         int k =-1;
         for(int i=0; i<s.length(); i++){
             if(s.charAt(i)=='*'){
                 ans.deleteCharAt(k);
                 k--;
             }
             else{
                 k++;
                 ans.append(s.charAt(i));
             }
         } 
         return ans.toString();
    }
}
