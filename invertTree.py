from collections import deque
class TreeNode:
	def __init__(self,val=0,left=None,right=None):
		self.val=val
		self.left=left
		self.right=right

class Solution:

# Approach 1- DFS (Recursive)
	def invertTree(self,root): # TC O(n) // SC O(n)
		if not root: return None 
		left=self.invertTree(root.left)
		right=self.invertTree(root.right)
		root.left=right 
		root.right=left 
		return root

# Approach 2- BFS (Iterative)
	def invertTree1(self,root): # TC O(n) // SC O(n)
		if not root: return 
		q=deque()
		q.append(root)
		while q:
			node=q.popleft()
			node.left,node.right=node.right,node.left
			if node.left: q.append(node.left) 
			if node.right: q.append(node.right) 

		return root 

	def inorder(self,root):
		if not root: return 
		self.inorder(root.left)
		print(root.val, end=" ")
		self.inorder(root.right)


root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(3)
s=Solution()
s.inorder(root)
print("")
res=s.invertTree(root)
s.inorder(res)
res1=s.invertTree1(root)
print("")
s.inorder(res1)





	