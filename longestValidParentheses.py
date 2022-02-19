'''
Approach- Using stacks 

Instead of finding every possible string and checking its validity, we can make use of a stack while 
scanning the given string to:

	1. Check if the string scanned so far is valid.
	2. Find the length of the longest valid string.
In order to do so, we start by pushing -1 onto the stack. For every ‘(’ encountered, 
we push its index onto the stack.

For every ")" encountered, we pop the topmost element. Then, the length of the currently 
encountered valid string of parentheses will be the difference between the current element's index 
and the top element of the stack.

If, while popping the element, the stack becomes empty, we will push the current element's index 
onto the stack. In this way, we can continue to calculate the length of the valid substrings and 
return the length of the longest valid string at the end.

'''
def longestValidParentheses(s): # TC O(n) // SC O(n)
	if not s:
		return s 
	stack=[]
	res=0
	stack.append(-1)
	for i in range(len(s)):
		if s[i]=="(":
			stack.append(i)
		else:
			stack.pop()
			if not stack:
				stack.append(i)
			else:
				res=max(res,i-stack[-1])
	return res 

'''
Approach - Using Dynamic Programming 



'''

def longestValidParentheses1(s): # TC O(n) // SC O(n) 	NOTE- still not working properly 
	res=0
	dp=[0 for i in range(len(s))]
	for i in range(len(s)):
	    if s[i]==")":
	        if s[i-1]=="(":
	            dp[i]= (dp[i-2] if i>=2 else 0 )+ 2
	        elif (i-dp[i-1]>0 and s[i-dp[i-1]-1])=="(":
	            dp[i]=dp[i-1]+(dp[i-dp[i-1]-2] if i-dp[i-1]>=2 else 0)+2
	        res=max(res,dp[i])
	return res

'''
Approach- Two pass and constant space 

In this approach, we make use of two counters leftleft and rightright. First, we start 
traversing the string from the left towards the right and for every ‘(’ encountered, 
we increment the leftleft counter and for every ‘)’ encountered, we increment the 
rightright counter. Whenever leftleft becomes equal to rightright, we calculate the length of 
the current valid string and keep track of maximum length substring found so far. If rightright 
becomes greater than leftleft we reset leftleft and rightright to 00.

Next, we start traversing the string from right to left and similar procedure is applied.

''' 
def longestValidParentheses2(s): # TC O(2n) --> O(n) // SC (1)
	#First scan from left to right 
	l,r=0,0 
	res=0
	for i in range(len(s)):
	    if s[i]=="(":
	        l+=1
	    else:
	        r+=1
	    if l==r:
	        res=max(res,2*r) # 2*r or 2*l does'nt matter 
	    elif r>=l:
	        l=r=0

	l=r=0
	#Second scan from right to left 
	for i in range(len(s)-1,-1,-1):
	    if s[i]=="(":
	        l+=1
	    else:
	        r+=1
	    if l==r:
	        res=max(res,2*l) # 2*r or 2*l does'nt matter 
	    elif l>=r:
	        l=r=0
	return res
print(longestValidParentheses(")()())"))
print(longestValidParentheses1(")("))
print(longestValidParentheses2(")(())()"))

