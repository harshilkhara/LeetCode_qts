# Approach 1- Very similar to makeGood.py 
def removeStringDuplicates(s): # TC O(n) SC O(n)
	stack=[]
	for char in s:
		if stack and stack[-1]==char:
			stack.pop()
		else:
			stack.append(char)

	return "".join(stack)

print(removeStringDuplicates("leelcode"))