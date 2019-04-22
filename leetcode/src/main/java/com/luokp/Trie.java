package com.luokp;

/**
 * @author: luokp
 * @date: 2019/4/19 22:26
 * @description:
 */
public class Trie {

    TrieNode root ;

    static final int ALPHABET_SIZE = 26;
    class TrieNode{
        int count;
        TrieNode[] children;
        public TrieNode() {
            count = 0;
            children = new TrieNode[ALPHABET_SIZE];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode point = root;
        for (int i = 0; i < word.length(); i++) {
            if(point.children[word.charAt(i) - 'a'] == null) {
                point.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            point = point.children[word.charAt(i) - 'a'];
        }
        point.count++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        TrieNode point = root;
        for (int i = 0; i < word.length(); i++) {
            if (point.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            point = point.children[word.charAt(i) - 'a'];
        }
        if(point.count != 0) {
            return true;
        }else {
            return false;
        }

    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        TrieNode point = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (point.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            point = point.children[prefix.charAt(i) - 'a'];
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
