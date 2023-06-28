from implementBST import *
class Solution:
# Approach 1- Inorder and HashSet
    def twoSumBSTs(self, root1, root2, target): # TC O(n) // SC O(n)
        seen1, seen2=set(), set()
        def inorder(root, seen):
            if not root: return 
            
            inorder(root.left, seen)
            seen.add(root.val)
            inorder(root.right, seen)
        
        inorder(root1, seen1)
        inorder(root2, seen2)
        
        for val in seen1:
            if target-val in seen2: return True 
        
        return False

bst=BST()
keys1=[2,1,4]
keys2=[1,0,3]
target=5
root1=bst.constructBST(keys1)
root2=bst.constructBST(keys2)
s=Solution()
print(s.twoSumBSTs(root1, root2, target))
