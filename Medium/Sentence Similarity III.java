class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.length()>s2.length())
            return areSentencesSimilar(s2,s1);

        String sm[] = s1.split(" "); 
        String lm[] = s2.split(" ");
         
        int s = 0,e1 = sm.length-1,e2 = lm.length-1;
        while( s<=e1 && sm[s].equals(lm[s]) ) s++;
        while( s<=e1 && sm[e1].equals(lm[e2]) ){
            e1--;
            e2--;
        }
        return (s>e1);
    }
}
