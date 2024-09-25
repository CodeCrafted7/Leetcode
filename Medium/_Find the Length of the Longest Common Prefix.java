class TrieNode {
    TrieNode[] children;
    int count;

    public TrieNode() {
        children = new TrieNode[10];
        count = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int index = ch - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++;
        }
    }

    public int findPrefixLength(String str) {
        TrieNode node = root;
        int prefixLength = 0;

        for (char ch : str.toCharArray()) {
            int index = ch - '0';
            if (node.children[index] != null && node.children[index].count > 0) {
                node = node.children[index];
                prefixLength++;
            } else {
                break;
            }
        }

        return prefixLength;
    }
}

class Solution {
    public int longestCommonPrefix(int[] a, int[] b) {
        Trie trie = new Trie();

        for (int y : b) {
            trie.insert(String.valueOf(y));
        }

        int maxPrefixLength = 0;

        for (int x : a) {
            String strX = String.valueOf(x);
            int prefixLength = trie.findPrefixLength(strX);
            maxPrefixLength = Math.max(maxPrefixLength, prefixLength);
        }

        return maxPrefixLength;
    }
}
