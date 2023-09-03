import java.util.*;
// Approach 1- Top Down DP with substring method
class Solution{ // TC O(n^3) SC O(n^2)
    Integer[] memo;
    HashSet<String> dictionarySet;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        memo = new Integer[n];
        dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        return dp(0, n, s);
    }
    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        // To count this character as a left over character 
        // move to index 'start + 1'
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            var curr = s.substring(start, end + 1);
            if (dictionarySet.contains(curr)) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }

        return memo[start] = ans;
    }
}

// Approach 2- Bottom up DP with substring method
class Solution1{ // TC O(n^3) SC O(n^2)
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        var dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        var dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                var curr = s.substring(start, end + 1);
                if (dictionarySet.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }
}

// Approach 3- Top Down DP with Trie
class TrieNode{ 
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode(){
        this.children=new HashMap<>();
        this.isWord=false;
    }
}

class Solution2{ // TC O(n^2) SC O(n^2)
    TrieNode root;
    Integer[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        root = buildTrie(dictionary);
        memo = new Integer[n + 1];
        return dp(0, n, s);
    }
    
    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        TrieNode node = root;
        // To count this character as a left over character 
        // move to index 'start + 1'
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            char c = s.charAt(end);
            if (!node.children.containsKey(c)) {
                break;
            }
            node = node.children.get(c);
            if (node.isWord) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }
        
        return memo[start] = ans;
    }
    
    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }
        return root;
    }
}

// Approach 4- Bottom up DP with Trie
class Solution3{ // TC O(n^2) SC O(n^2)
    public int minExtraChar(String s, String[] dictionary) {
        int n= s.length();
        int[] dp = new int[n+1];
        TrieNode root = buildTrie(dictionary);

        for(int start=n-1; start>=0; start--){
            dp[start]=dp[start+1]+1;
            TrieNode node=root;
            for(int end=start; end<n; end++){
                if(!node.children.containsKey(s.charAt(end))) break;

                node=node.children.get(s.charAt(end));
                if(node.isWord) {
                    dp[start] = Math.min(dp[start], dp[end+1]);
                }
            }
        }
        return dp[0];
    }

    public TrieNode buildTrie(String[] dictionary){
        TrieNode root = new TrieNode();
        for(String word: dictionary){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(!node.children.containsKey(c)){
                    node.children.put(c, new TrieNode());
                }
                node=node.children.get(c); 
            }
            node.isWord=true;
        }
        return root;
    }
}

class minExtraChar{
    public static void main(String[] args) {
        String x="sayhelloworld";
        String[] dictionary={"hello", "world"};
        Solution s= new Solution();
        System.out.println(s.minExtraChar(x, dictionary));
        Solution1 s1= new Solution1();
        System.out.println(s1.minExtraChar(x, dictionary));
        Solution2 s2= new Solution2();
        System.out.println(s2.minExtraChar(x, dictionary));
        Solution3 s3= new Solution3();
        System.out.println(s3.minExtraChar(x, dictionary));
    }
}