'''
Approach- Brute Force 

To generate all sequences, we use a recursion. All sequences of length n is just '(' plus all 
sequences of length n-1, and then ')' plus all sequences of length n-1.

To check whether a sequence is valid, we keep track of balance, the net number of opening 
brackets minus closing brackets. If it falls below zero at any time, or doesn't end in zero, 
the sequence is invalid - otherwise it is valid.

'''
def generateParenthesis(n): # TC O(2^(2n).n) // SC O(2^(2n).n)
	def generate(A = []):
		if len(A) == 2*n:
		    if valid(A):
		        ans.append("".join(A))
		else:
		    A.append('(')
		    generate(A)
		    A.pop()
		    A.append(')')
		    generate(A)
		    A.pop()

	def valid(A):
		bal = 0
		for c in A:
		    if c == '(': bal += 1
		    else: bal -= 1
		    if bal < 0: return False
		return bal == 0

	ans = []
	generate()
	return ans
'''
Approach- Backtracking 

Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it will 
remain a valid sequence. We can do this by keeping track of the number of opening and closing 
brackets we have placed so far.
We can start an opening bracket if we still have one (of n) left to place. And we can start a 
closing bracket if it would not exceed the number of opening brackets.

'''
def generateParenthesis1(n): # TC O(4^n/sqrt(n)) // SC O(4^n/sqrt(n))
	ans = []
	def backtrack(S = [], left = 0, right = 0):
	    if len(S) == 2 * n:
	        ans.append("".join(S))
	        return
	    if left < n:
	        S.append("(")
	        backtrack(S, left+1, right)
	        S.pop()
	    if right < left:
	        S.append(")")
	        backtrack(S, left, right+1)
	        S.pop()
	backtrack()
	return ans

print(generateParenthesis(3))
print(generateParenthesis1(3))

