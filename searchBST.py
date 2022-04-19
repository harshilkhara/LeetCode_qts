# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
    def insert(root,val):
       if root is None:
           return TreeNode(val)
       else:
           if root.val == val:
               return root
           elif root.val < val:
               root.right = TreeNode.insert(root.right,val)
           else:
               root.left = TreeNode.insert(root.left,val)
       return root
    
    def searchBST(root, val):  # TC O(H) --> O(log n) // SC (1)
        while root is not None and root.val!=val:
            root=root.left if val<root.val else root.right 
        return root

root=TreeNode(4)
root.insert(2)
root.insert(7)
root.insert(1)
root.insert(3)
print(root.searchBST(2))

#print(searchBST([4,2,7,1,3],2))
