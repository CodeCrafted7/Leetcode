class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int st=0;
        int e=s.length()-1;
        while(st<e)
        {
            while(st<e && !isVowels(chars[st]))
            st++;

            while(st<e && !isVowels(chars[e]))
            e--;
            if(st<e)
            {
                swap(chars,st,e);
                st++;
                e--;
            }
        }
        return new String(chars);
    }
    private void swap(char[] word, int start, int end){
        char temp = word[start];
        word[start] = word[end];
        word[end] = temp;
    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
