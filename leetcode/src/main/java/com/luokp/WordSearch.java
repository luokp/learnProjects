package com.luokp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: luokp
 * @date: 2019/4/30 19:29
 * @description:
 */
public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }

        Trie trie = new Trie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsAndTrie(board, trie.root, i, j, result);
            }
        }

        return result;

    }


    private void dfsAndTrie(char[][] board, TrieNode node, int row, int col, List<String> result) {
        if(outOfBounds(board, row, col)|| board[row][col] == '#' || node.children[board[row][col]-'a'] == null) {
            return;
        }
        node = node.children[board[row][col]-'a'];
        char c = board[row][col];
        if(node.isEndOfWord) {
            result.add(node.word);
            node.isEndOfWord = false;
        }
        board[row][col] = '#';

        dfsAndTrie(board, node, row-1, col, result);
        dfsAndTrie(board, node, row+1, col, result);
        dfsAndTrie(board, node, row, col-1, result);
        dfsAndTrie(board, node, row, col+1, result);
        board[row][col] = c;
    }

    private boolean outOfBounds(char[][] board, int x, int y) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }


    class TrieNode {
        int count;
        boolean isEndOfWord;
        String word;
        TrieNode[] children;

        public TrieNode() {
            this.count = 0;
            this.word = null;
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;


        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        public Trie(String[] words) {
            this.root = new TrieNode();
            for(String word : words) {
                insert(word);
            }
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.count++;
            curr.isEndOfWord = true;
            curr.word = word;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null) {
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            if(curr.count == 0) {
                return false;
            }
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(curr.children[c-'a'] == null) {
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] b = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] w = {"oath","pea","eat","rain"};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.findWords(b,w));
    }
}
