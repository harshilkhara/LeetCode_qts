class Solution:
# Approach 1- DFS (Recursive) [using implicit call-stack]
    def minDepth(self, root): # TC O(n) // SC O(n)
        if not root: 
            return 0 
        
        children = [root.left, root.right]
        # if we're at leaf node
        if not any(children):
            return 1
        
        min_depth = float('inf')
        for c in children:
            if c:
                min_depth = min(self.minDepth(c), min_depth)
        return min_depth + 1 

# Approach 2- BFS [using queue]
    def minDepth1(self, root): # TC O(n) // SC O(n)
        if not root: return 0
        q=deque()
        q.append(root)
        depth=0
        while q:
            #currNode=q.popleft()
            depth+=1
            for node in range(len(q)):
                currNode=q.popleft()
                if not currNode.left and not currNode.right:
                    return depth
                if currNode.left: q.append(currNode.left)
                if currNode.right: q.append(currNode.right)
            
        
        return depth

s=Solution()
print(s.min_depth(root))