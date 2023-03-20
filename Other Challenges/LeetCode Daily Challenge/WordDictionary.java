package org.weeklydsa.Daily_Challenges;

import org.weeklydsa.Node.TrieNode;

public class WordDictionary {
    private final TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode child = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (child.trie[index] == null) {
                child.trie[index] = new TrieNode();
            }
            child = child.trie[index];
        }
        child.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return bfs(root, word.toCharArray(), 0);
    }

    private boolean bfs(TrieNode root, char[] word, int index) {
        if(index == word.length) {
            return root.isEndOfWord;
        }
        char c = word[index];
        if(c != '.') {
            int i = c - 'a';
            if (root.trie[i] != null && bfs(root.trie[i], word, index + 1)) {
                return true;
            }
        } else {
            for (TrieNode child : root.trie) {
                if (child != null && bfs(child, word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}