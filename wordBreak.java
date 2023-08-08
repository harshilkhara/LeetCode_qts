import java.util.*;
// Approach 1- Brute Force 


// Approach 2- BFS 
class Solution1 { // TC O(n^3) SC O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }
}

// Approach 3- Top down DP 
class Solution2{ // TC O(n.m.k) SC O(n)
    private String s;
    private List<String> wordDict;
    private int[] memo;
    
    private boolean dp(int i) {
        if (i < 0) return true;
        
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        
        for (String word: wordDict) {
            // Handle out of bounds case
            if (i - word.length() + 1 < 0) {
                continue;
            }
            
            if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp(i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }
        
        memo[i] = 0;
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()];
        Arrays.fill(this.memo, -1);
        return dp(s.length() - 1);
    }
}

// Approach 4- Bottom down DP
class Solution3{ // TC O(m.n.k) SC O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word: wordDict) {
                // Handle out of bounds case
                if (i < word.length() - 1) {
                    continue;
                }
                
                if (i == word.length() - 1 || dp[i - word.length()]) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;   
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}

class wordBreak{
    public static void main(String[] args) {
        String x="leetcode";
        List<String> wordDict=new ArrayList<>(Arrays.asList("leet","code"));
        Solution1 s1= new Solution1();
        System.out.println(s1.wordBreak(x,wordDict));
        Solution2 s2= new Solution2();
        System.out.println(s2.wordBreak(x,wordDict));
    }
}