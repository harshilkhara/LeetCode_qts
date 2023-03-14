class TreeNode:
	def __init__(self, val=None, left=None, right=None):
		self.val=val 
		self.left=left 
		self.right=right

class Solution:
# Approach 1- Recursive DFS (Preorder) [using call-stack]
	def sumNumbers(self, root): # TC O(n) // SC O(n)
		total=0
		def preorder(root, currNumber):
			nonlocal total 

			if root:
				currNumber=currNumber*10+root.val 

				if not root.left and not root.right:
					total+=currNumber 

				preorder(root.left, currNumber)
				preorder(root.right, currNumber)

			return total 

		return preorder(root,0)

# Approach 2- Iterative DFS (Preorder) [using explicit stack]
	def sumNumbers1(self, root): # TC O(n) // SC O(n)
		total=0 
		currNumber=0
		stack=[(root,0)]
		while stack:
			node, currNumber=stack.pop()
			if node:
				currNumber=currNumber*10+node.val 

				if not node.left and not node.right:
					total+=currNumber
				else:
					stack.append((node.right, currNumber))
					stack.append((node.left, currNumber))

		return total 

root=TreeNode(4)
root.left=TreeNode(9)
root.right=TreeNode(0)
root.left.left=TreeNode(5)
root.left.right=TreeNode(1)
s=Solution()
print(s.sumNumbers(root))
print(s.sumNumbers1(root))