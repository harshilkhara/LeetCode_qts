// Very similar to topKFrequent.py & .java 
// Approach 1- Brute Force 
import java.util.*;
class Solution { // TC O(n log n) SC O(n)
    public List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(cnt.keySet());
        Collections.sort(candidates,
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w1.compareTo(w2) : // Note this compare
                cnt.get(w2) - cnt.get(w1));
        return candidates.subList(0, k);
    }
}

// Approach 2- Max Heap 
class Solution1{ // TC O(n + k log n) SC O(n)
    class Word implements Comparable<Word> {
        private String word;
        private int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(Word other) {
            if (this.count == other.count) {
                return this.word.compareTo(other.word);
            }
            return other.count - this.count;
        }
    }

    public List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<Word> candidates = new ArrayList<>();
        for (var entry : cnt.entrySet()) {
            candidates.add(new Word(entry.getKey(), entry.getValue()));
        }

        Queue<Word> h = new PriorityQueue<>(candidates);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(h.poll().word);
        }
        return res;

    }
}

// Solution 3- Min Heap
class Solution2{ // TC O(n log k) SC O(n)
    public List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> h = new PriorityQueue<>(
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? 
                w2.compareTo(w1) : cnt.get(w1) - cnt.get(w2)); // Note this compare

        for (String word : cnt.keySet()) {
            h.offer(word);
            if (h.size() > k)
                h.poll();
        }

        List<String> res = new ArrayList<>();
        while (!h.isEmpty())
            res.add(h.poll());
        Collections.reverse(res);
        return res;
    }
}

// Solution 4- Bucket Sort + Trie 
class Solution3{ // TC O(n) SC O(n)
    private int k;
    private List<String> res;

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public List<String> topKFrequentWords(String[] words, int k) {
        this.k = k;
        res = new ArrayList<>();
        int n = words.length;
        TrieNode[] bucket = new TrieNode[n + 1];
        Map<String, Integer> cnt = new HashMap<>();

        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        for (var entry : cnt.entrySet()) {
            if (bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new TrieNode();
            addWord(bucket[entry.getValue()], entry.getKey());
        }

        for (int i = n; i > 0; i--) {
            if (bucket[i] != null) {
                getWords(bucket[i], "");
            }
            if (this.k == 0) {
                break;
            }
        }
        return res;

    }

    private void addWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    private void getWords(TrieNode root, String prefix) {
        if (k == 0)
            return;
        if (root.isWord) {
            k--;
            res.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], prefix + (char) (i + 'a'));
            }
        }
    }
}

class topKFrequentWords{ 
    public static void main(String[] args) {
        String[] words={"i","love","leetcode","i","love","coding"};
        int k= 2;
        Solution s= new Solution();
        System.out.println(s.topKFrequentWords(words,k));
        Solution1 s1= new Solution1();
        System.out.println(s1.topKFrequentWords(words,k));
        Solution2 s2= new Solution2();
        System.out.println(s1.topKFrequentWords(words,k));
        Solution3 s3= new Solution3();
        System.out.println(s1.topKFrequentWords(words,k));
    }
}