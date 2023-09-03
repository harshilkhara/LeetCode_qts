from functools import lru_cache
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False

class Solution:
# Approach 1- Top Down DP with substring method
    def minExtraChar(self, s, dictionary): # TC O(n^3) SC O(n^2)
        n, dictionary_set = len(s), set(dictionary)
        @lru_cache
        def dp(start):
            if start == n:
                return 0
            # To count this character as a left over character 
            # move to index 'start + 1'
            ans = dp(start + 1) + 1
            for end in range(start, n):
                curr = s[start: end + 1]
                if curr in dictionary_set:
                    ans = min(ans, dp(end + 1))
            return ans
            
        return dp(0)

# Approach 2- Bottom Up DP with substring method
    def minExtraChar1(self, s, dictionary): # TC O(n^3) SC O(n^2)
        n = len(s)
        dictionary_set = set(dictionary)
        dp = [0] * (len(s) + 1)

        for start in range(n - 1, -1, -1):
            dp[start] = 1 + dp[start + 1]
            for end in range(start, n):
                curr = s[start: end + 1]
                if curr in dictionary_set:
                    dp[start] = min(dp[start], dp[end + 1])

        return dp[0]

    def buildTrie(self, dictionary):
        root = TrieNode()
        for word in dictionary:
            node = root
            for char in word:
                if char not in node.children:
                    node.children[char] = TrieNode()
                node = node.children[char]
            node.is_word = True
        return root

# Approach 3- Top Down DP with Trie
    def minExtraChar2(self, s, dictionary): # TC O(n^2) SC O(n^2)
        n = len(s)
        root = self.buildTrie(dictionary)
        
        @lru_cache
        def dp(start):
            if start == n:
                return 0
            # To count this character as a left over character 
            # move to index 'start + 1'
            ans = dp(start + 1) + 1
            node = root
            for end in range(start, n):
                if s[end] not in node.children:
                    break
                node = node.children[s[end]]
                if node.is_word:
                    ans = min(ans, dp(end + 1))
            return ans
        
        return dp(0)

# Approach 4- Bottom Up DP with Trie
    def minExtraChar3(self, s, dictionary): # TC O(n^2) SC O(n^2)
        n = len(s)
        root = self.buildTrie(dictionary)
        dp = [0] * (n + 1)
        
        for start in range(n - 1, -1, -1):
            dp[start] = dp[start + 1] + 1
            node = root
            for end in range(start, n):
                if s[end] not in node.children:
                    break
                node = node.children[s[end]]
                if node.is_word:
                    dp[start] = min(dp[start], dp[end + 1])
        
        return dp[0]

s=Solution()
x="sayhelloworld"
dictionary=["hello", "world"]
print(s.minExtraChar(x, dictionary))
print(s.minExtraChar1(x, dictionary))
print(s.minExtraChar2(x, dictionary))
print(s.minExtraChar3(x, dictionary))
