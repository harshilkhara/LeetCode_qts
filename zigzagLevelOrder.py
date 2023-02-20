from collections import deque
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:

# Approach 1- BFS
    def zigzagLevelOrder(self,root): # TC O(n) // SC O(n)
        ans=[]
        if not root: return ans
        q=deque()
        q.append(root)
        level=0
        while q:
            lst=[]
            for i in range(len(q)):
                currNode=q.popleft()
                lst.append(currNode.val)
                if currNode.left: q.append(currNode.left)
                if currNode.right: q.append(currNode.right)
            if level%2:
                lst.reverse()
            level+=1
            ans.append(lst)
        
        return ans

# Approach 2- BFS 
    def zigzagLevelOrder1(self, root): # TC O(n) // SC O(n)
        ret = []
        level_list = deque()
        if root is None:
            return []
        # start with the level 0 with a delimiter
        node_queue = deque([root, None])
        is_order_left = True

        while len(node_queue) > 0:
            curr_node = node_queue.popleft()

            if curr_node:
                if is_order_left:
                    level_list.append(curr_node.val)
                else:
                    level_list.appendleft(curr_node.val)

                if curr_node.left:
                    node_queue.append(curr_node.left)
                if curr_node.right:
                    node_queue.append(curr_node.right)
            else:
                # we finish one level
                ret.append(level_list)
                # add a delimiter to mark the level
                if len(node_queue) > 0:
                    node_queue.append(None)

                # prepare for the next level
                level_list = deque()
                is_order_left = not is_order_left

        return ret


# Approach 3- DFS 
    def zigzagLevelOrder2(self, root): # TC O(n) // SC O(n)
        if root is None:
            return []

        results = []
        def dfs(node, level):
            if level >= len(results):
                results.append(deque([node.val]))
            else:
                if level % 2 == 0:
                    results[level].append(node.val)
                else:
                    results[level].appendleft(node.val)

            for next_node in [node.left, node.right]:
                if next_node is not None:
                    dfs(next_node, level+1)

        # normal level order traversal with DFS
        dfs(root, 0)

        return results


root=TreeNode(3)
root.left=TreeNode(9)
root.right=TreeNode(20)
root.right.left=TreeNode(15)
root.right.right=TreeNode(7)
s=Solution()
print(s.zigzagLevelOrder(root))
print(s.zigzagLevelOrder1(root))
print(s.zigzagLevelOrder2(root))

