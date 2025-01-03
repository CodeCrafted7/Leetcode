public class Solution {
    private static final Set<Character> VOWEL = Set.of('a', 'e', 'i', 'o', 'u');

    private int[] P;

    public int[] vowelStrings(String[] words, int[][] queries) {
        this.P = new int[words.length + 1];

        for (int i = 0; i < words.length; i++)
            P[i + 1] = P[i] + isValidString(words[i]);

        return Arrays.stream(queries)
                .mapToInt(this::query)
                .toArray();
    }

    private int query(int[] q) {
        return P[q[1] + 1] - P[q[0]];
    }

    private int isValidString(String word) {
        boolean startsWithVowel = VOWEL.contains(word.charAt(0));
        boolean endsWithVowel = VOWEL.contains(word.charAt(word.length() - 1));
        
        return startsWithVowel && endsWithVowel ? 1 : 0;
    }
}
