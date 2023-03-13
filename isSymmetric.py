from collections import deque
class TreeNode:
    def __init__(self, val=None, left=None, right=None):
        self.val=val 
        self.left=left 
        self.right=right 

class Solution:
# Approach 1- Recursive (DFS) [using implicit call stack]
    def isSymmetric(self, root): # TC O(n) // SC O(n)

        def isMirror(t1,t2):
            if not t1 and not t2: return True 
            if not t1 or not t2: return False 
            return t1.val==t2.val and isMirror(t1.left, t2.right) and isMirror(t1.right, t2.left)

        return isMirror(root,root)

# Approach 2- Iterative (BFS) [using queue]
    def isSymmetric1(self, root): # TC O(n) // SC O(n)
        q=deque()
        q.append(root)
        q.append(root)
        while q:
            t1,t2=q.popleft(), q.popleft()
            if not t1 and not t2: continue 
            if not t1 or not t2: return False 
            if t1.val!=t2.val: return False 
            q.append(t1.left)
            q.append(t2.right)
            q.append(t1.right)
            q.append(t2.left)
        
        return True

s=Solution()
root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(2)
root.left.left=TreeNode(4)
root.left.right=TreeNode(3)
root.right.left=TreeNode(3)
root.right.right=TreeNode(4)
print(s.isSymmetric(root))
print(s.isSymmetric1(root))

