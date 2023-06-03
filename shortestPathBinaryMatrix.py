from collections import deque
class Solution:
# Approach 1- BFS (distance on queue)
    def shortestPathBinaryMatrix(self, grid): # TC O(n) // SC O(n)
        
        max_row = len(grid) - 1
        max_col = len(grid[0]) - 1
        directions = [
            (-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        
        # Helper function to find the neighbors of a given cell.
        def get_neighbours(row, col):
            for row_difference, col_difference in directions:
                new_row = row + row_difference
                new_col = col + col_difference
                if not(0 <= new_row <= max_row and 0 <= new_col <= max_col):
                    continue
                if grid[new_row][new_col] != 0:
                    continue
                yield (new_row, new_col)
        
        # Check that the first and last cells are open. 
        if grid[0][0] != 0 or grid[max_row][max_col] != 0:
            return -1
        
        # Set up the BFS.
        queue = deque([(0, 0, 1)])
        visited = {(0, 0)}
        
        # Do the BFS.
        while queue:
            row, col, distance = queue.popleft()
            if (row, col) == (max_row, max_col):
                return distance
            for neighbour in get_neighbours(row, col):
                if neighbour in visited:
                    continue
                visited.add(neighbour)
                # Note that the * splits neighbour into its values.
                queue.append((*neighbour, distance + 1))
                
        # There was no path.
        return -1

s=Solution()
print(s.shortestPathBinaryMatrix([[0,1],[1,0]]))