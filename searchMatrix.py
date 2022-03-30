#Approach 1- Binary Search 
def searchMatrix(matrix,target): # TC O(log (m*n)) // SC O(1)
	m=len(matrix)
	if m==0:
		return False
	n=len(matrix[0])

	#binary search 
	left,right=0, m*n-1 
	while left<=right:
		pivot_index=(left+right)//2
		pivot_element=matrix[pivot_index//n][pivot_index%n] # row = idx // n, column= idx % n 
		if pivot_element==target:
			return True 
		elif pivot_element<target:
			left=pivot_index+1
		else:
			right=pivot_index-1 

	return False 

#Approach 2- Brute Force (Coded up by me)

def searchMatrix1(matrix,target):
	for i in range(len(matrix)):
		for j in range(len(matrix[0])):
			if matrix[i][j]==target:
				return True 
	return False 

print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],20))
print(searchMatrix1([[1,3,5,7],[10,11,16,20],[23,30,34,60]],13))

