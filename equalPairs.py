import collections
class TrieNode:
    def __init__(self):
        self.children={}
        self.count=0 
        
class Trie:
    def __init__(self):
        self.root=TrieNode()
    
    def insert(self, array):
        curr=self.root 
        for n in array:
            if n not in curr.children:
                curr.children[n]=TrieNode()
            curr=curr.children[n]
        
        curr.count+=1 
    
    def search(self, array):
        curr=self.root 
        for n in array:
            if n in curr.children:
                curr=curr.children[n]
            else:
                return 0
        
        return curr.count

class Solution:
# Approach 1- Brute Force
    def equalPairs(self, grid): # TC O(n^3) // SC O(n)
        count = 0
        n = len(grid)
        
        # Check each row r against each column c.
        for r in range(n):
            for c in range(n):
                match = True
                
                # Iterate over row r and column c.
                for i in range(n):
                    if grid[r][i] != grid[i][c]:
                        match = False
                        break
                        
                # If row r equals column c, increment count by 1.
                count += int(match)
                    
        return count

# Approach 2- HashMap
    def equalPairs1(self, grid): # TC O(n^2) // SC O(n)
        count = 0
        n = len(grid)
        
        # Keep track of the frequency of each row.
        row_counter = collections.Counter(tuple(row) for row in grid)

        # Add up the frequency of each column in map.
        for c in range(n):
            col = [grid[i][c] for i in range(n)]
            count += row_counter[tuple(col)]

            
        return count

# Approach 3- Trie
    def equalPairs2(self, grid): # TC O(n^2) // SC O(n)
        t=Trie()
        n=len(grid)
        count=0
        for row in grid:
            t.insert(row)
        
        for c in range(n):
            cols=[None]*n
            for r in range(n):
                cols[r]=grid[r][c]
            count+=t.search(cols)
        
        return count

s=Solution()
print(s.equalPairs([[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]))
print(s.equalPairs1([[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]))
print(s.equalPairs2([[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]))
