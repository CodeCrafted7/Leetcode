class Solution {
    class Item {
        String letters;
        int num;
        char uniqueCharacter;
        public Item(String letters, int num, char c) {
            this.letters = letters;
            this.num = num;
            this.uniqueCharacter = c;
        }
        public void derive(int[] count, int[] numArr) {
            if (count[uniqueCharacter - 'a'] > 0) {
                numArr[num] = count[uniqueCharacter - 'a'];
                for (int i=0; i<letters.length(); i++) {
                    char letter = letters.charAt(i);
                    count[letter - 'a'] -= numArr[num];
                }
            }
        }
    }
    public String originalDigits(String s) {
        int[] count = new int[26];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            count[ c - 'a']++;
        }
        int[] numArr = new int[10];
        Item[] arr = new Item[10];
        arr[0] = new Item("zero", 0, 'z');
        arr[1] = new Item("two", 2, 'w');
        arr[2] = new Item("four", 4, 'u');
        arr[3] = new Item("six", 6, 'x');
        arr[4] = new Item("eight", 8, 'g');
        arr[5] = new Item("one", 1, 'o');
        arr[6] = new Item("three", 3, 'r');
        arr[7] = new Item("five", 5, 'f');
        arr[8] = new Item("seven", 7, 'v');
        arr[9] = new Item("nine", 9, 'i');

        for (Item item: arr) {
            item.derive(count, numArr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numArr.length; i++) {
            int freq = numArr[i];
            for (int j=0; j<freq; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
