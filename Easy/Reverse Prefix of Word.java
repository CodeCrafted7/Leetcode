class Solution {
    public String reversePrefix(String word, char ch) {
        int index=word.indexOf(ch);
        if(index!=-1)
        return reverse(index,index+1,word);  
        else 
        return word;
    }
    
    public String reverse(int i,int j,String word){
        StringBuilder sb=new StringBuilder();
        while(i>=0){
            sb.append(word.charAt(i--));
        }
        while(j<word.length())
        sb.append(word.charAt(j++));
        
        return sb.toString();
    }
}
