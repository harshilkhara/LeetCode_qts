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

// Approach 3- DP 
class Solution2{ // TC O(n^3) SC O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
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