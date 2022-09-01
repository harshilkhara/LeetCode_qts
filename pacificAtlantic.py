from collections import deque

#Approach 1- BFS [using queue]
def pacificAtlantic(matrix): # TC O(m*n) // SC O(m*n)
        # Check if input is empty
        if not matrix or not matrix[0]: 
            return []
            
        num_rows, num_cols = len(matrix), len(matrix[0])

        # Setup each queue with cells adjacent to their respective ocean
        pacific_queue = deque()
        atlantic_queue = deque()
        for i in range(num_rows):
            pacific_queue.append((i, 0))
            atlantic_queue.append((i, num_cols - 1))
        for i in range(num_cols):
            pacific_queue.append((0, i))
            atlantic_queue.append((num_rows - 1, i))
        
        def bfs(queue):
            reachable = set()
            while queue:
                (row, col) = queue.popleft()
                # This cell is reachable, so mark it
                reachable.add((row, col))
                for (x, y) in [(1, 0), (0, 1), (-1, 0), (0, -1)]: # Check all 4 directions
                    new_row, new_col = row + x, col + y
                    # Check if the new cell is within bounds
                    if new_row < 0 or new_row >= num_rows or new_col < 0 or new_col >= num_cols:
                        continue
                    # Check that the new cell hasn't already been visited
                    if (new_row, new_col) in reachable:
                        continue
                    # Check that the new cell has a higher or equal height,
                    # So that water can flow from the new cell to the old cell
                    if matrix[new_row][new_col] < matrix[row][col]:
                        continue
                    # If we've gotten this far, that means the new cell is reachable
                    queue.append((new_row, new_col))
            return reachable
        
        # Perform a BFS for each ocean to find all cells accessible by each ocean
        pacific_reachable = bfs(pacific_queue)
        atlantic_reachable = bfs(atlantic_queue)
        
        # Find all cells that can reach both oceans, and convert to list
        return list(pacific_reachable.intersection(atlantic_reachable))


#Approach 2- DFS (Recursive)
def pacificAtlantic1(matrix):
    # Check if input is empty
    if not matrix or not matrix[0]: 
        return []
    
    # Initialize variables, including sets used to keep track of visited cells
    num_rows, num_cols = len(matrix), len(matrix[0])
    pacific_reachable = set()
    atlantic_reachable = set()
    
    def dfs(row, col, reachable):
        # This cell is reachable, so mark it
        reachable.add((row, col))
        for (x, y) in [(1, 0), (0, 1), (-1, 0), (0, -1)]: # Check all 4 directions
            new_row, new_col = row + x, col + y
            # Check if the new cell is within bounds
            if new_row < 0 or new_row >= num_rows or new_col < 0 or new_col >= num_cols:
                continue
            # Check that the new cell hasn't already been visited
            if (new_row, new_col) in reachable:
                continue
            # Check that the new cell has a higher or equal height,
            # So that water can flow from the new cell to the old cell
            if matrix[new_row][new_col] < matrix[row][col]:
                continue
            # If we've gotten this far, that means the new cell is reachable
            dfs(new_row, new_col, reachable)
    
    # Loop through each cell adjacent to the oceans and start a DFS
    for i in range(num_rows):
        dfs(i, 0, pacific_reachable)
        dfs(i, num_cols - 1, atlantic_reachable)
    for i in range(num_cols):
        dfs(0, i, pacific_reachable)
        dfs(num_rows - 1, i, atlantic_reachable)
    
    # Find all cells that can reach both oceans, and convert to list
    return list(pacific_reachable.intersection(atlantic_reachable))

print(pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))
print(pacificAtlantic1([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))
