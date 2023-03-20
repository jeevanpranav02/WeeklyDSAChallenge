package org.weeklydsa.Daily_Challenges;

import org.weeklydsa.Node.TrieNode;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode child = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (child.trie[index] == null) {
                return false;
            }
            child = child.trie[index];
        }
        return child.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode child = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (child.trie[index] == null) {
                return false;
            }
            child = child.trie[index];
        }
        return true;
    }
}
