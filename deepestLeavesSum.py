from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val=val
        self.left=left
        self.right=right 

class Solution:

# Approach 1- DFS (Iterative) [using explicit stack]
    def deepestLeavesSum(self, root): # TC O(n) // SC O(n)
        deepest_sum = depth = 0
        stack = [(root, 0) ]
        
        while stack:
            node, curr_depth = stack.pop()
            if node.left is None and node.right is None:
                # if this leaf is the deepest one seen so far
                if depth < curr_depth:
                    deepest_sum = node.val      # start new sum
                    depth = curr_depth          # note new depth
                # if there were already leaves at this depth
                elif depth == curr_depth:
                    deepest_sum += node.val     # update existing sum
                    
            else:
                if node.right:
                    stack.append((node.right, curr_depth + 1))
                if node.left:
                    stack.append((node.left, curr_depth + 1))
                        
        return deepest_sum

# Approach 2- DFS (Recursive) [using implicit call stack]
    def deepestLeavesSum1(self, root): # TC O(n) // SC O(n)
        deepest_sum = depth = 0
        queue = deque([(root, 0),])

        while queue:
            node, curr_depth = queue.popleft()
            if node.left is None and node.right is None:
                # if this leaf is the deepest one seen so far
                if depth < curr_depth:
                    deepest_sum = node.val      # start new sum
                    depth = curr_depth          # note new depth
                # if there were already leaves at this depth
                elif depth == curr_depth:
                    deepest_sum += node.val     # update existing sum    
            else:
                if node.left:
                    queue.append((node.left, curr_depth + 1))
                if node.right:
                    queue.append((node.right, curr_depth + 1))
                        
        return deepest_sum

# Approach 3- Optimized BFS
    def deepestLeavesSum2(self, root): # TC O(n) // SC O(n)
        next_level = deque([root,])
        
        while next_level:
            # prepare for the next level
            curr_level = next_level
            next_level = deque()
            
            for node in curr_level:
                # add child nodes of the current level
                # in the queue for the next level
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
        
        return sum([node.val for node in curr_level])

root=TreeNode(1)
root= TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(3)
root.left.left= TreeNode(4)
root.left.right= TreeNode(5)
root.right.right= TreeNode(6)
root.left.left.left= TreeNode(7)
root.right.right.right= TreeNode(8)
s=Solution()
print(s.deepestLeavesSum(root))
print(s.deepestLeavesSum1(root))
print(s.deepestLeavesSum2(root))