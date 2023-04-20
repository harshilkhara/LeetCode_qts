from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
# Approach 1- BFS     
    def widthOfBinaryTree(self, root): # TC O(n) // SC O(n)
        if not root: return 0
        queue=deque()
        queue.append([root, 0])
        maxDepth=0
        while queue:
            head, headColumnIndex=queue[0]
            size=len(queue)
            #node, columnIndex=None
            for _ in range(size):
                node, columnIndex=queue.popleft()
                if node.left:
                    queue.append([node.left, columnIndex*2])
                if node.right:
                    queue.append([node.right, columnIndex*2+1])
                    
            maxDepth=max(maxDepth, columnIndex-headColumnIndex+1)
        
        return maxDepth

# Approach 2- DFS 
    def widthOfBinaryTree1(self, root): # TC O(n) // SC O(n)
        maxWidth=0 
        colMap={}
        def dfs(root, depth, columnIndex):
            nonlocal maxWidth
            if not root: return 

            if depth not in colMap:
                colMap[depth]=columnIndex

            firstColIndex=colMap[depth]

            maxWidth=max(maxWidth, columnIndex-firstColIndex+1)
            dfs(root.left, depth+1, columnIndex*2)
            dfs(root.right, depth+1, columnIndex*2+1)

        dfs(root, 0, 0)
        return maxWidth 

root=TreeNode(1)
root.left= TreeNode(2);
root.right= TreeNode(3);
root.left.left= TreeNode(5);
root.left.right= TreeNode(3);
root.right.right= TreeNode(9);
s=Solution()
print(s.widthOfBinaryTree(root))
print(s.widthOfBinaryTree1(root))

