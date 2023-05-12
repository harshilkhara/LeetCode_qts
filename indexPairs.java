import java.util.*;
import java.util.stream.Collectors;
// Approach 1- Brute Force
class Solution { // # TC O(n.s + m^3) SC O(n.s)
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> result = new ArrayList<>();
        Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                if (wordsSet.contains(text.substring(i, j + 1))) {
                    result.add(new int[] {i, j});
                }
            }
        }
        int[][] ans = new int[result.size()][];
        ans = result.toArray(ans);
        return ans;
    }
}

// Approach 2- Trie
class TrieNode{
    HashMap<Character, TrieNode> children= new HashMap<Character,TrieNode>();
    boolean word=false;

    public TrieNode(){
    }
}

class Trie{

    TrieNode root; 

    public Trie(){
        root= new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }
}

class Solution1{ // TC O(n.s + m^2) SC O(n.s)
    public int[][] indexPairs(String text, String[] words){
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            TrieNode p = trie.root;
            for (int j = i; j < text.length(); j++) {
                if (p.children.get(text.charAt(j)) == null) {
                    break;
                }
                p = p.children.get(text.charAt(j));
                if (p.word) {
                    result.add(new int[] { i, j });
                }
            }
        }
        int[][] ans = new int[result.size()][];
        ans = result.toArray(ans);
        return ans;
    }
}


class indexPairs{
    public static void main(String[] args) {
        String text="thestoryofleetcodeandm";
        String[] words={"story","fleet","leetcode"};
        Solution s= new Solution();
        System.out.println(Arrays.deepToString(s.indexPairs(text, words)));
        Solution1 s1= new Solution1();
        System.out.println(Arrays.deepToString(s1.indexPairs(text, words)));
    }
}