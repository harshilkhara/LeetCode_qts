# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
def getAllElements(root1,root2): # TC O(N+M) // SC O(N+M)
	 stack1, stack2, output = [], [], []
        
	while root1 or root2 or stack1 or stack2:
	    # update both stacks
	    # by going left till possible
	    while root1:
	        stack1.append(root1)
	        root1 = root1.left
	    while root2:
	        stack2.append(root2)
	        root2 = root2.left

	    # Add the smallest value into output,
	    # pop it from the stack,
	    # and then do one step right
	    if not stack2 or stack1 and stack1[-1].val <= stack2[-1].val:
	        root1 = stack1.pop()
	        output.append(root1.val)
	        root1 = root1.right
	    else:
	        root2 = stack2.pop()
	        output.append(root2.val)   
	        root2 = root2.right
	return output

print(getAllElements([2,1,4],[1,0,3]))
