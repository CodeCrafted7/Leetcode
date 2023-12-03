class Solution {
    public int countCharacters(String[] words, String chars) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (isGood(words[i], chars)) {
                System.out.println("Good");
                count += words[i].length();
            }
        }

        return count;
    }

    private boolean isGood(String word, String chars) {
        Map<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Hashmap before modification  " + hm);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (hm.containsKey(ch) && hm.get(ch) > 0) {
                hm.put(ch, hm.get(ch) - 1);
            } else {
                return false;
            }
        }
        System.out.println("Hashmap after modification " + hm);
        return true;
    }
}
