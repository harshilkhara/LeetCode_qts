'''
Approach 1- Sort an almost sorted arrays where 2 elements are swapped 

1) Construct inorder traversal of the tree. It should be an almost sorted list where only two 
   elements are swapped.

2) Identify two swapped elements x and y in an almost sorted array in linear time.

3) Traverse the tree again. Change value x to y and value y to x.

'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
    def insert(r,val):
       if r is None:
           return TreeNode(val)
       else:
           if r.val == val:
               return r
           elif r.val < val:
               r.right = TreeNode.insert(r.right,val)
           else:
               r.left = TreeNode.insert(r.left,val)
       return r

    def inorder(r):
        return inorder(r.left) + [r.val] + inorder(r.right) if r else []

    def find_two_swapped(nums):
        n = len(nums)
        x = y = None # Initialize x and y as a value that cannot be the value of a node.
        for i in range(n - 1):
            if nums[i + 1] < nums[i]:
                y = nums[i + 1]
                # first swap occurrence
                if x is None:     
                    x = nums[i]
                # second swap occurrence
                else:           
                    break
        return x, y

    def recoverBST(r,count): # TC O(n) // SC O(n)
        if r:
            if r.val == x or r.val == y:
                r.val = y if r.val == x else x
                count -= 1
                if count == 0:
                    return      
            recoverBST(r.left, count)
            recoverBST(r.right, count)

    nums = inorder(r)
    x, y = find_two_swapped(nums)
    recover(r, 2)

'''

Now we will discuss three more approaches, and basically they are all the same :

1) Merge steps 1 and 2, i.e. identify swapped nodes during the inorder traversal.

2) Swap node values.

The difference in-between the following approaches is in a chosen method to implement 
inorder traversal :

Approach 2 : Iterative.

Approach 3 : Recursive.

Approach 4 : Morris.

'''
#Approach 2- Iterative 

def recoverBST1(root): # TC O(n) // SC O(n)
    stack = []
    x = y = pred = None

    while stack or root:
        while root:                # Step 1
            stack.append(root)
            root = root.left
        root = stack.pop()
        if pred and root.val < pred.val: # Step 2
            y = root
            if x is None:
                x = pred 
            else:
                break
        pred = root                      # Step 1
        root = root.right                # Step 1

    x.val, y.val = y.val, x.val

#Approach 3- Recursive 

def recoverBST2(root): # TC O(n) // SC O(n)
    def find_two_swapped(root: TreeNode):
        nonlocal x, y, pred
        if root is None:
            return

        find_two_swapped(root.left)
        if pred and root.val < pred.val:
            y = root
            # first swap occurence
            if x is None:
                x = pred 
            # second swap occurence
            else:
                return
        pred = root
        find_two_swapped(root.right)

    x = y = pred = None
    find_two_swapped(root)
    x.val, y.val = y.val, x.val

#Approach 4- Morris inorder traversal 

def recoverBST3(root): # TC O(n) // SC O(1)
    # predecessor is a Morris predecessor. 
    # In the 'loop' cases it could be equal to the node itself predecessor == root.
    # pred is a 'true' predecessor, 
    # the previous node in the inorder traversal.
    x = y = predecessor = pred = None

    while root:
    # If there is a left child
    # then compute the predecessor.
    # If there is no link predecessor.right = root --> set it.
    # If there is a link predecessor.right = root --> break it.
    if root.left:       
        # Predecessor node is one step left 
        # and then right till you can.
        predecessor = root.left
        while predecessor.right and predecessor.right != root:
            predecessor = predecessor.right

        # set link predecessor.right = root
        # and go to explore left subtree
        if predecessor.right is None:
            predecessor.right = root
            root = root.left
        # break link predecessor.right = root
        # link is broken : time to change subtree and go right
        else:
            # check for the swapped nodes
            if pred and root.val < pred.val:
                y = root
                if x is None:
                    x = pred 
            pred = root

            predecessor.right = None
            root = root.right
    # If there is no left child
    # then just go right.
    else:
        # check for the swapped nodes
        if pred and root.val < pred.val:
            y = root
            if x is None:
                x = pred 
        pred = root

        root = root.right

    x.val, y.val = y.val, x.val

print(recoverBST([1,3,null,null,2]))
#Answer- [3,1,null,null,2]

