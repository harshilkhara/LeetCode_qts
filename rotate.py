#Approach 1- Rotate groups of 4 cells 
def rotate(matrix):   # TC O(M) // SC O(1)   M--> number of cells in the matrix 
	n = len(matrix[0])
	for i in range(n // 2 + n % 2):
	    for j in range(n // 2):
	        tmp = matrix[n - 1 - j][i]
	        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]
	        matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i]
	        matrix[j][n - 1 - i] = matrix[i][j]
	        matrix[i][j] = tmp
	return matrix

'''
Approach 2- Reverse on Diagonal and then reverse left to right 
First Transpose
Then reverse 

''' 
def rotate1(matrix):  # TC O(M) // SC O(1) M--> number of cells in the matrix 
    transpose(matrix)
    reflect(matrix) # reverse 
    return matrix 

def transpose(matrix):
    n = len(matrix)
    for i in range(n):
        for j in range(i + 1, n):
            matrix[j][i], matrix[i][j] = matrix[i][j], matrix[j][i]

def reflect(matrix):
    n = len(matrix)
    for i in range(n):
        for j in range(n // 2):
            matrix[i][j], matrix[i][-j - 1] = matrix[i][-j - 1], matrix[i][j]



print(rotate([[1,2,3],[4,5,6],[7,8,9]]))
print(rotate1([[1,2,3],[4,5,6],[7,8,9]]))