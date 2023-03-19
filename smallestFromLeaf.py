class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val=val 
        self.left=left
        self.right=right


class Solution:

# Approach 1- DFS (Recursive) [using implict call-stack]
    def smallestFromLeaf(self, root): # TC O(n) // SC O(n)

        def dfs(root):
            nonlocal ans
            if not root: return 
            
            sb.append(chr(ord('a')+root.val))
            
            if not root.left and not root.right:
                ans=min(ans, "".join(reversed(sb)))
            
            dfs(root.left)
            dfs(root.right)
            sb.pop()
    
    
        sb=[]
        ans='~'
        dfs(root)
        return ans

root=TreeNode(0)
root.left=TreeNode(1)
root.right=TreeNode(2)
root.left.left=TreeNode(3)
root.left.right=TreeNode(4)
root.right.left=TreeNode(3)
root.right.right=TreeNode(4)
s=Solution()
print(s.smallestFromLeaf(root))