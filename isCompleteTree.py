from collections import deque
# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:

# Approach 1- BFS [using queue]
    def isCompleteTree(self, root): # TC O(n) // SC O(n)
        if not root: return True
        nullNode=False
        q=deque()
        q.append(root)
        while q:
            node=q.popleft()
            if not node:
                nullNode=True
            else:
                if nullNode:
                    return False 
                q.append(node.left)
                q.append(node.right)
        return True

# Approach 2- DFS (Recursive) [using implicit call-stack]
    def isCompleteTree1(self, root):
        if not root: return True 

        def countNodes(root):
            if not root: return 0 

            return 1 + countNodes(root.left) + countNodes(root.right)

        def dfs(root, index, n):
            if not root: return True 

            if index>=n: return False 

            return dfs(root.left, 2*index+1, n) and dfs(root.right, 2*index+2, n) 


        return dfs(root, 0, countNodes(root))


root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(3)
root.left.left=TreeNode(4)
root.left.right=TreeNode(5)
root.right.left=TreeNode(6)
s=Solution()
print(s.isCompleteTree(root))
print(s.isCompleteTree1(root))
            
