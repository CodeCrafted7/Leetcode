class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int f[] = new int[26],s[] = new int[26];

        for(char c : s1.toCharArray())
            f[c-'a'] +=1;

        int w = s1.length()-1;

        for(int i=0; i<s2.length(); i++){
            s[s2.charAt(i)-'a'] += 1;
            if( i>= w){
                if(match(f,s)) return true;
                s[s2.charAt(i-w)-'a'] -= 1;
            }
        }

        return false;
    }
    public static boolean match(int f[],int s[]){
        for(int i=0;i<26;i++){
            if(f[i] !=  s[i]) return false;
        }
        return true;
    }
}
