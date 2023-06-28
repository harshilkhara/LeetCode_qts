class TreeNode:
	def __init__(self, val=0, left=None, right=None):
		self.val=val 
		self.left=left
		self.right=right


class BST:
	def __init__(self):
		self.root=TreeNode()

	def insert(self, root, val):
		if not root:
			return TreeNode(val)

		if val<root.val:
			root.left=self.insert(root.left, val) 
		else:
			root.right=self.insert(root.right, val)

		return root 

	def constructBST(self, keys):
		self.root=None  
		for key in keys:
			self.root=self.insert(self.root, key)

		return self.root

	def inorder(self, root):
		if not root: return 

		self.inorder(root.left)
		print(root.val, end=" ")
		self.inorder(root.right)

# bst=BST()
# keys=[4,2,6,1,3]
# root=bst.constructBST(keys)
# bst.inorder(root) 