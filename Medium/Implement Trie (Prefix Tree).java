class Trie {
    class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(temp.children[index] == null){
                temp.children[index] = new Node();
            }
            temp = temp.children[index];
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        Node temp = root;

        for(char c: word.toCharArray()){
            if(temp.children[c - 'a'] == null) return false;

            temp = temp.children[c-'a'];
        }

        return temp.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;

        for(char c: prefix.toCharArray()){
            if(temp.children[c - 'a'] == null) return false;
            temp = temp.children[c - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
