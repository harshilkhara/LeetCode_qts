'''
Approach 1- Divide and Conquer 

Intuition

Split the string into S = A + B where A and B are balanced parentheses strings, and A is the 
smallest possible non-empty prefix of S.

Algorithm

Call a balanced string primitive if it cannot be partitioned into two non-empty balanced strings.

By keeping track of balance (the number of ( parentheses minus the number of ) parentheses), 
we can partition S into primitive substrings S = P_1 + P_2 + ... + P_n. Then, score(S) = score(P_1) 
+ score(P_2) + ... + score(P_n), by definition.

For each primitive substring (S[i], S[i+1], ..., S[k]), if the string is length 2, 
then the score of this string is 1. Otherwise, it's twice the score of the substring (S[i+1], S[i+2], 
..., S[k-1]).

'''
def scoreOfParentheses(s): # TC O(N^2) // SC O(N)
	def F(i, j):
	    #Score of balanced string s[i:j]
	    ans = bal = 0

	    #Split string into primitives
	    for k in range(i, j):
	        bal += 1 if s[k] == '(' else -1
	        if bal == 0:
	            if k - i == 1:
	                ans += 1
	            else:
	                ans += 2 * F(i+1, k)
	            i = k+1

	    return ans

	return F(0, len(s))
'''
Approach 2- Stack 

Every position in the string has a depth - some number of matching parentheses surrounding it. 
For example, the dot in (()(.())) has depth 2, because of these parentheses: (__(.__))

Our goal is to maintain the score at the current depth we are on. When we see an opening bracket, 
we increase our depth, and our score at the new depth is 0. When we see a closing bracket, 
we add twice the score of the previous deeper part - except when counting (), which has a score of 1.

For example, when counting (()(())), our stack will look like this:

[0, 0] after parsing (
[0, 0, 0] after (
[0, 1] after )
[0, 1, 0] after (
[0, 1, 0, 0] after (
[0, 1, 1] after )
[0, 3] after )
[6] after )

'''
def scoreOfParentheses1(s): # TC O(N) // SC O(N)
	stack=[0]
	for i in s:
	    if i=="(":
	        stack.append(0)
	    else:
	        v=stack.pop()
	        stack[-1]+=max(2*v,1)

	return stack.pop()

'''
Appraoach 3- Count Cores 

Intuition

The final sum will be a sum of powers of 2, as every core (a substring (), with score 1) 
will have it's score multiplied by 2 for each exterior set of parentheses that contains that core.

Algorithm

Keep track of the balance of the string, as defined in Approach #1. For every ) that immediately 
follows a (, the answer is 1 << balance, as balance is the number of exterior set of parentheses 
that contains this core.

'''
def scoreOfParentheses2(s): # TC O(N) // SC O(1)
	ans = bal = 0
	for i, x in enumerate(s):
	    if x == '(':
	        bal += 1
	    else:
	        bal -= 1
	        if s[i-1] == '(':
	            ans += 1 << bal
	return ans

print(scoreOfParentheses("(())"))
print(scoreOfParentheses1("(()(()))"))
print(scoreOfParentheses2("(()(()))()"))


