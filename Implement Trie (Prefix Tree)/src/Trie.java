import java.util.HashMap;

/**
 * Created by Shinelon on 2017/7/10.
 */
public class Trie {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("abc");
        obj.insert("ab");
        System.out.println(obj.search("ab"));
        System.out.println(obj.startsWith("ab"));
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    class TrieNode {
        HashMap<Character, TrieNode> childInfo;
        boolean flag = false;
        TrieNode() {
            childInfo = new HashMap<>();
        }
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] letters = word.toCharArray();
        TrieNode temp = root;
        for(char c : letters) {
            HashMap<Character, TrieNode> map = temp.childInfo;
            if(map.get(c) == null) {
                TrieNode nextNode = new TrieNode();
                map.put(c, nextNode);
                temp = nextNode;
            }else{
                temp = map.get(c);
            }
        }
        temp.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] letters = word.toCharArray();
        TrieNode temp = root;
        for(char c : letters) {
            HashMap<Character, TrieNode> map = temp.childInfo;
            if(map.get(c) == null)
                return false;
            temp = map.get(c);
        }
        if(temp.flag)
            return true;
        else
            return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        TrieNode temp = root;
        for(char c : letters) {
            HashMap<Character, TrieNode> map = temp.childInfo;
            if(map.get(c) == null)
                return false;
            temp = map.get(c);
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