import java.util.*;
// Very Similar to wordBreak.java & wordBreak.py DP logic 
// Approach 1- DP
class Solution { // TC O(M^3. N) SC O(M.N)
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict=new HashSet<>(Arrays.asList(words));
        List<String> ans= new ArrayList<>();
        for(String word: words){
            int length=word.length();
            boolean[] dp=new boolean[length+1];
            dp[0]=true; 
            for(int i=1; i<=length; i++){
                for(int j=(i==length ? 1:0); !dp[i] && j<i; j++){
                    dp[i]=dp[j] && dict.contains(word.substring(j,i));
                }
            }
            if(dp[length]){
                ans.add(word);
            }
        }
        return ans;
    }
}

// Approach 2- DFS 
class Solution1{ // TC O(M^3. N) SC O(M.N)
    private boolean dfs(final String word, int length, final boolean[] visited, final Set<String> dictionary) {
        if (length == word.length()) {
            return true;
        }
        if (visited[length]) {
            return false;
        }
        visited[length] = true;
        for (int i = word.length() - (length == 0 ? 1 : 0); i > length; --i) {
            if (dictionary.contains(word.substring(length, i)) 
                && dfs(word, i, visited, dictionary)) {
                return true;
            }
            
        }
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        final List<String> answer = new ArrayList<>();
        for (final String word : words) {
            final int length = word.length();
            final boolean[] visited = new boolean[length];
            if (dfs(word, 0, visited, dictionary)) {
                answer.add(word);
            }
        }
        return answer;   
    }
}

class findAllConcatenatedWordsInADict{
    public static void main(String[] args) {
        String[] words={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses",
        "rat","ratcatdogcat"};
        Solution s= new Solution();
        System.out.println(s.findAllConcatenatedWordsInADict(words));
        Solution1 s1= new Solution1();
        System.out.println(s1.findAllConcatenatedWordsInADict(words));
    }
}