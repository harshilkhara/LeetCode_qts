class Solution:
# Approach 1- Brute Force
	def countNegatives(self, grid): # TC O(n^2) // SC O(1)
		count = 0
		# Iterate on all elements of the matrix one by one.
		for row in grid:
			for element in row:
			    # If the current element is negative, we count it.
			    if element < 0:
			        count += 1
		return count

# Approach 2- Binary Search
	def countNegatives1(self, grid): # TC O(n log n) // SC O(1)
		count = 0
		n = len(grid[0])
		# Iterate on all rows of the matrix one by one.
		for row in grid:
		    # Using binary search find the index
		    # which has the first negative element.
		    left, right = 0, n - 1
		    while left <= right:
		        mid = (right + left) // 2
		        if row[mid] < 0:
		            right = mid - 1
		        else:
		            left = mid + 1
		    # 'left' points to the first negative element,
		    # which means 'n - left' is the number of all negative elements.
		    count += (n - left)
		return count

# Approach 3- Linear Traversal
	def countNegatives2(self, grid): # TC O(n) SC O(1)
		count = 0
		n = len(grid[0])
		currRowNegativeIndex = n - 1

		# Iterate on all rows of the matrix one by one.
		for row in grid:
		    # Decrease 'currRowNegativeIndex' so that it points to current row's last positive element.
		    while currRowNegativeIndex >= 0 and row[currRowNegativeIndex] < 0:
		        currRowNegativeIndex -= 1
		    # 'currRowNegativeIndex' points to the last positive element,
		    # which means 'n - (currRowNegativeIndex + 1)' is the number of all negative elements.
		    count += (n - (currRowNegativeIndex + 1))
		return count

s=Solution()
print(s.countNegatives([[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]))
print(s.countNegatives1([[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]))
print(s.countNegatives2([[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]))
