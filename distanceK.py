from collections import defaultdict, deque
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
# Approach 1- DFS on equivalent graph
    def distanceK(self, root, target, k): # TC O(n) SC O(n)
        answer=[]
        graph=defaultdict(list)
        
        def buildGraph(currNode, parent):
            if currNode and parent:
                graph[currNode.val].append(parent.val)
                graph[parent.val].append(currNode.val)
            
            if currNode.left: buildGraph(currNode.left, currNode)
            
            if currNode.right: buildGraph(currNode.right, currNode)
        
        def dfs(curr, distance):
            if distance==k:
                answer.append(curr)
                return 
            
            for neighbor in graph[curr]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    dfs(neighbor, distance+1)
            
            return
        
        buildGraph(root, None)
        
        visited=set([target.val])
        
        dfs(target.val, 0)
        
        return answer

# Approach 2- BFS on equivalent graph
    def distanceK1(self, root, target, k): # TC O(n) SC O(n)
        graph = defaultdict(list)
        # Recursively build the undirected graph from the given binary tree.
        def build_graph(cur, parent):
            if cur and parent:
                graph[cur.val].append(parent.val)
                graph[parent.val].append(cur.val)
            if cur.left:
                build_graph(cur.left, cur)
            if cur.right:
                build_graph(cur.right, cur) 
        build_graph(root, None)
        
        answer = []
        visited = set([target.val])

        # Add the target node to the queue with a distance of 0
        queue = deque([(target.val, 0)])
        while queue:
            cur, distance = queue.popleft()

            # If the current node is at distance k from target,
            # add it to the answer list and continue to the next node.
            if distance == k:
                answer.append(cur)
                continue

            # Add all unvisited neighbors of the current node to the queue.
            for neighbor in graph[cur]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, distance + 1))
                    
        return answer

s=Solution()
root=TreeNode(3)
root.left=TreeNode(5);
root.right= TreeNode(1);
root.left.left= TreeNode(6);
root.left.right= TreeNode(2);
root.left.right.left= TreeNode(7);
root.left.right.right= TreeNode(4);
root.right.left= TreeNode(0);
root.right.right= TreeNode(8);
target=root.left
print(s.distanceK(root,target,2))
print(s.distanceK1(root,target,2))
    
        
    