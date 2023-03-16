class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    def preorder(self, root):
        if not root: return
        print(root.val, end=" ")
        self.preorder(root.left)
        self.preorder(root.right)

class Solution:
# Approach 1- DFS (Recursion) [using implicit call-stack]
    def buildTree(self, inorder, postorder): # TC O(n) // SC O(n)
        def helper(in_left, in_right):
            # if there is no elements to construct subtrees
            if in_left > in_right:
                return None
            
            # pick up the last element as a root
            val = postorder.pop()
            root = TreeNode(val)

            # root splits inorder list
            # into left and right subtrees
            index = idx_map[val]
 
            # build right subtree
            root.right = helper(index + 1, in_right)
            # build left subtree
            root.left = helper(in_left, index - 1)
            return root
        
        # build a hashmap value -> its index
        idx_map = {val:idx for idx, val in enumerate(inorder)} 
        return helper(0, len(inorder) - 1)

s=Solution()
result=(s.buildTree([9,3,15,20,7],[9,15,7,20,3]))
t=TreeNode()
print(t.preorder(result))
