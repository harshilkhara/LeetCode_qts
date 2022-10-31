# Approach 1- Group by category 
def isToeplitzMatrix(matrix): # TC O(m*n) // SC O(m+n)
	groups = {}
	for r, row in enumerate(matrix):
	    for c, val in enumerate(row):
	        if r-c not in groups:
	            groups[r-c] = val
	        elif groups[r-c] != val:
	            return False
	return True

# Approach 2- Compare with top-left neighbor
def isToeplitzMatrix1(matrix): # TC O(m*n) // SC O(1)
	return all(r == 0 or c == 0 or matrix[r-1][c-1] == val
	           for r, row in enumerate(matrix)
	           for c, val in enumerate(row))


print(isToeplitzMatrix([[1,2,3,4],[5,1,2,3],[9,5,1,2]]))
print(isToeplitzMatrix1([[1,2,3,4],[5,1,2,3],[9,5,1,2]]))