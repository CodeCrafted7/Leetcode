class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int c1[] = new int[26];
        licensePlate = licensePlate.toLowerCase();
		
        for(int i=0; i<licensePlate.length(); i++)
        {
            if(Character.isAlphabetic(licensePlate.charAt(i)))
                c1[(int)(licensePlate.charAt(i) - 97)]++;
        }
        
        int count[][] = new int[words.length][26];
		
        for(int i=0; i<words.length; i++)
        {
            for(int j=0; j<words[i].length(); j++)
                count[i][(int)(words[i].charAt(j) - 97)]++;
        }
		
        List<String> l = new ArrayList();
        int max = Integer.MAX_VALUE;
		
        for(int i=0; i<words.length; i++)
        {
            int c = 0;
            for(int j=0; j<26; j++)
            {
                if(count[i][j] >= c1[j])
                    c++;
            }
            if(c == 26)
            {
                int len = words[i].length();
                if(len < max)
                {
                    max = len;
                    l.add(words[i]);
                }
            }
        }

        return l.get(l.size()-1);
    }
}
