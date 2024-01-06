class Solution {
    public String[] findWords(String[] words) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        String[] key = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        
        for(int i=0;i<3;i++) {
            String w = key[i];
            for(int j=0;j<w.length();j++) {
                char ch = w.charAt(j);
                hm.put(ch,i);
            }
        }
        
        List<String> li = new ArrayList<>();
        
        for(int i=0;i<words.length;i++) {
            
            String word = words[i];
            boolean flag = true;
            int pos = hm.get(Character.toLowerCase(word.charAt(0)));
            
            for(int j=0;j<word.length();j++) {
                char ch = word.charAt(j);
                
                if(hm.get(Character.toLowerCase(ch)) != pos) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                li.add(word);
            }
        }
         
        String[] res = new String[li.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = li.get(i);
        }
        
        return res;
    }
}
