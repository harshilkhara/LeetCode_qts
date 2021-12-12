# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

def maxDepth(root): # Recursive DFS -- TC O(n)  // SC O(n)
        if not root:
            return 0
        return 1+max(self.maxDepth(root.left),self.maxDepth(root.right))

        
def maxDepth1(root): # Iterative DFS -- TC O(n) // SC O(n)
    stack=[[root,1]]
    res=0
    while stack:
        node,depth=stack.pop()
        if node:
            res=max(res,depth)
            stack.append([node.left,depth+1])
            stack.append([node.right,depth+1])
    return res


def maxDepth2(root):    # BFS Approach -- TC O(n) // SC O(n)
        if not root:
            return 0
        level=0
        q=deque([root]) #Deque means Doubly ended queue
        while q:
            for i in range(len(q)):
                node=q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            level+=1
        return level