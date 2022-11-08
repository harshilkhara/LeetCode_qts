# Approach 1- Stack 
def makeGood(s): # TC O(n) SC O(n)
	stack=[]
	for c in s:
		if stack and abs(ord(stack[-1])-ord(c)==32):
			stack.pop()
		else:
			stack.append(c)

	return "".join(stack)

# Approach 2- Brute Force (Recursive) [using implict call stack]
def makeGood1(s): # TC O(n) SC O(n)
	for i in range(len(s) - 1):
	    if abs(ord(s[i]) - ord(s[i + 1])) == 32:
	        return makeGood(s[:i] + s[i + 2:])
	# Base case, if we can't find a pair, just return 's'.
	return s

print(makeGood("leeEetcode"))
print(makeGood1("leeEetcode"))

