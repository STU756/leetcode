package com.jia.leetCode;
/**
 * 208. 实现 Trie (前缀树)
 * 
 * 
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

	示例:
	
	Trie trie = new Trie();
	
	trie.insert("apple");
	trie.search("apple");   // 返回 true
	trie.search("app");     // 返回 false
	trie.startsWith("app"); // 返回 true
	trie.insert("app");   
	trie.search("app");     // 返回 true
	说明:
	
	你可以假设所有的输入都是由小写字母 a-z 构成的。
	保证所有输入均为非空字符串。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0208 {
    class TrieNode{
        boolean isWord;
        TrieNode[] child;
        TrieNode(){
            isWord = false;
            child = new TrieNode[26];
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Pro0208() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        for(int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if(node.child[id] == null) {
                node.child[id] = new TrieNode();
            }
            node = node.child[id];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if(node.child[id] == null)
                return false;
            node = node.child[id];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            int id = prefix.charAt(i) - 'a';
            if(node.child[id] == null)
                return false;
            node = node.child[id];
        }
        return true;
    }
}
