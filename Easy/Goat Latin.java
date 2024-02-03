class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder res=new StringBuilder("");
        StringBuilder a= new StringBuilder("");
        for(int i=0;i<words.length;i++){
            if(!"aeiouAEIOU".contains(words[i].charAt(0)+"")){
                res.append(words[i].substring(1)).append(words[i].charAt(0)).append("maa").append(a+" ");
            }else{
                res.append(words[i]).append("maa").append(a+" ");
            }
            a.append("a");
        }
        return res.toString().trim();
    }
}
