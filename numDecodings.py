# Approach 1- Top down DP (Recursive with memoization)
def numDecodings(s): # TC O(n) // SC O(n)
	def recursiveWithMemo(index,s):
	    # If you reach the end of the string
	    # Return 1 for success.
	    if index == len(s):
	        return 1

	    # If the string starts with a zero, it can't be decoded
	    if s[index] == '0':
	        return 0

	    if index == len(s)-1:
	        return 1
	    
	    answer = recursiveWithMemo(index + 1, s)
	    if int(s[index : index + 2]) <= 26:
	        answer += recursiveWithMemo(index + 2, s)

	    return answer

	return recursiveWithMemo(0, s)

# Approach 2- Bottom Up (Iterative)
def numDecodings1(s): # TC O(n) // SC O(n)
	dp=[0]* (len(s)+1)
	dp[0]=1 

	dp[1]= 0 if s[0]=='0' else 1 

	for i in range(2,len(dp)):
		if s[i-2]!='0':
			dp[i]=dp[i-1]

		twoDigit=int(s[i-2:i])
		if twoDigit>= 10 and twoDigit<=26:
			dp[i]+=dp[i-2]

	return dp[len(s)]

# Approach 3- Bottom up but constant space(Iterative)
def numDecodings2(s): # TC O(n) // SC O(1)
	if s[0] == "0":
	    return 0

	two_back = 1
	one_back = 1
	for i in range(1, len(s)):
	    current = 0
	    if s[i] != "0":
	        current = one_back
	    two_digit = int(s[i - 1: i + 1])
	    if two_digit >= 10 and two_digit <= 26:
	        current += two_back
	    two_back = one_back
	    one_back = current

	return one_back

print(numDecodings("226"))
print(numDecodings1("226"))
print(numDecodings2("226"))
