class Solution {
public boolean halvesAreAlike(String s) {
        int s1 = 0, s2 = 0, mid = s.length()/2;
        for(int i = 0; i < mid; i++) {
            char a = Character.toLowerCase(s.charAt(i));
            if(a == 'a' || a=='e' || a =='i'|| a=='o'|| a=='u') s1++;
        }
        for (int j = s.length()-1; j >= mid; j--) {
            char b= Character.toLowerCase(s.charAt(j));
            if(b=='a' || b=='e' || b =='i'|| b=='o'|| b=='u') s2++;
        }
    return s1 == s2;
    }
}
