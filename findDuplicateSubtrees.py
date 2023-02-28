from collections import defaultdict
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

# Approach 1- Inorder Traversal and HashMap
class Solution:
    def findDuplicateSubtrees(self, root): # TC O(n) // SC O(n)
        def traverse(node):
            if not node:
                return ""
            representation = ("(" + traverse(node.left) + ")" + str(node.val)
                              + "(" + traverse(node.right) + ")")
            cnt[representation] += 1
            if cnt[representation] == 2:
                res.append(node.val)
            return representation
        cnt = defaultdict(int)
        res = []
        traverse(root)
        return res

root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(3)
root.left.left=TreeNode(4)
root.right.left=TreeNode(2)
root.right.left.left=TreeNode(4)
root.right.right=TreeNode(4)
s=Solution()
print(s.findDuplicateSubtrees(root))

