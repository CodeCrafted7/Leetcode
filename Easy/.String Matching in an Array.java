class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(word)) {
                    set.add(word);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
