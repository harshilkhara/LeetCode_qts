import math
# Approach 1- String Traversal
def zigzagConversion(s,numRows): # TC O(n) // SC O(1)
	if numRows==1: return s 
	n=len(s)
	charsInSection=2*numRows-2
	ans=""
	for currRow in range(numRows):
		index=currRow

		while index<n:
			ans+=s[index]
			if currRow!=0 and currRow!=numRows-1:
				charsInBetween=charsInSection-2*currRow
				secondIndex=index+charsInBetween

				if secondIndex<n: 
					ans+=s[secondIndex]

			index+=charsInSection


	return ans 


# Approach 2- Simulate zigzag movement 
def zigzagConversion1(s,num_rows): # TC O(num_rows*n) // SC O(num_rows*n)
	if num_rows == 1:
		return s
        
	n = len(s)
	sections = math.ceil(n / (2 * num_rows - 2.0))
	num_cols = sections * (num_rows - 1)

	matrix = [[' '] * num_cols for _ in range(num_rows)]

	curr_row, curr_col = 0, 0
	curr_string_index = 0

	# Iterate in zig-zag pattern on matrix and fill it with string characters.
	while curr_string_index < n:
	    # Move down.
	    while curr_row < num_rows and curr_string_index < n:
	        matrix[curr_row][curr_col] = s[curr_string_index]
	        curr_row += 1
	        curr_string_index += 1
	        
	    curr_row -= 2
	    curr_col += 1
	    
	    # Move up (with moving right also).
	    while curr_row > 0 and curr_col < num_cols and curr_string_index < n:
	        matrix[curr_row][curr_col] = s[curr_string_index]
	        curr_row -= 1
	        curr_col += 1
	        curr_string_index += 1

	answer = ""
	for row in matrix:
	    answer += "".join(row)
	    
	return answer.replace(" ", "")

print(zigzagConversion("PAYPALISHIRING",3))
print(zigzagConversion1("PAYPALISHIRING",3))

