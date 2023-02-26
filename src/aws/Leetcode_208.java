package aws;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_208 {

    class TrieNode{
        boolean endOfWord;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode getChild(char c){
            return children.getOrDefault(c, null);
        }
        public void addChild(char c){
            if (!children.containsKey(c))
                children.put(c, new TrieNode());
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for(char c: word.toCharArray()){
                node.addChild(c);
                node = node.getChild(c);
            }
            node.endOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c: word.toCharArray()){
                if (node == null || !node.children.containsKey(c))
                    return false;
                node = node.getChild(c);
            }
            return node.endOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c: prefix.toCharArray()){
                if (node == null || !node.children.containsKey(c))
                    return false;
                node = node.getChild(c);
            }
            return true;
        }
    }
}
