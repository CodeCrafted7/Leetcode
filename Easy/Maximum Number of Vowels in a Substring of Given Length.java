class Solution {
    public int maxVowels(String s, int k) {
        int l=0,r=0,w=0,res=0;
        for(;r<k;r++)
          w+=isVowel(s.charAt(r));
          res=w;
        while(r<s.length())
        {
            w-=isVowel(s.charAt(l++));
            w+=isVowel(s.charAt(r++));
            res = Math.max(res,w);
        }
        return res;
        
    }

        private int isVowel(char c )
        {
            return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u')?1:0;
        }
}
