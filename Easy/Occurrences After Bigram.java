class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length - 2; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second)) list.add(split[i + 2]);
        }
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
