package org.example.Practice;

import java.util.*;

public class Trie {

    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        System.out.println("inserting: " + word);
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isEndOfWord = true;
    }

    boolean search(String word) {
        System.out.println("searching: " + word);
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                return false;
            cur = cur.children.get(c);
        }
        return cur.isEndOfWord;
    }

    void delete(String word) {
        System.out.println("deleting: " + word);
        boolean removeCharacter = deleteInternal(root, word, 0);
    }

    private boolean deleteInternal(TrieNode node, String word, int idx) {
        if (idx == word.length()) {
            node.isEndOfWord = false;
            return node.children.isEmpty(); //remove character's node if its not a part of any other word
        }
        char c = word.charAt(idx);
        if (node.children.containsKey(c)) {
            boolean removeCharacter = deleteInternal(node.children.get(c), word, idx + 1);
            if (removeCharacter) {
                node.children.remove(c);
                return node.children.isEmpty();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("abcd"));
        trie.insert("def");
        trie.insert("ab");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("ab"));
        trie.insert("abde");
        trie.insert("abcdef");
        System.out.println(trie.search("abdef"));
        System.out.println(trie.search("abcde"));
        System.out.println(trie.search("abcdef"));
        trie.delete("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("abcdef"));
        trie.insert("abc");
    }

}
