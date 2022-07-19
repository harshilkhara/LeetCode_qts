import java.util.*;
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

    // search a prefix or whole key in trie and
    // returns the node where search ends
   	public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
           if (node.children.containsKey(ch)) {
               node = node.children.get(ch);
           } else {
               return null;
           }
        }
        return node;
    }

    public boolean search(String word){
    	TrieNode node = root;
    	node = searchPrefix(word);
       return node != null && node.word; 
    }

    public boolean startsWith(String prefix){
    	TrieNode node = root;
    	node = searchPrefix(prefix);
        return node != null;

    }
}

class implementTrie{

	public static void main(String [] args){
		Trie t= new Trie();
		t.insert("harshil");
		t.insert("khara");
		t.insert("kimaya");
		System.out.println(t.startsWith("har")); // true
		System.out.println(t.search("khaa"));    // false
		System.out.println(t.search("harsh"));   // false
		System.out.println(t.startsWith("khe")); // true
		System.out.println(t.search("khara"));   // true
		System.out.println(t.startsWith("Khara"));   // false

	}
}
