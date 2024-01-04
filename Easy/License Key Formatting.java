class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String temp = "", formatted="";
        s = s.toUpperCase();
        System.out.println(s);
        int count=k;
        for(int i=s.length()-1 ; i>=0 ; i--){
            if(s.charAt(i)!='-'){
                if(count==0){
                    temp+='-';
                    count=k;
                }
                temp+=s.charAt(i);
                count--;
            }
        }
        for(int i=temp.length()-1 ; i>=0 ; i--){
            formatted += temp.charAt(i);
        }
        return formatted; 
    }
}
