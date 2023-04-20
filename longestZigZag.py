class Solution:
# Approach 1- DFS
    def longestZigZag(self, root): # TC O(n) // SC O(n)
        visited=0
        
        def dfs(root, isLeft, steps):
            nonlocal visited 
            
            if not root: return 
            
            visited=max(visited, steps)
            if isLeft: 
                dfs(root.left, False, steps+1)
                dfs(root.right, True, 1)
            else:
                dfs(root.left, False, 1)
                dfs(root.right, True, steps+1)
            
        dfs(root, False, 0)
        dfs(root, True, 0)
        return visited

s=Solution()
print(s.longestZigZag(root))
