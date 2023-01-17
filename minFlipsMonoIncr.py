# Approach 1- Dp 
def minFlipsMonoIncr(s): # TC O(n) // SC O(1)
	ans,ones=0,0 
	for c in s:
		if c=='0':
			ans=min(ones,ans+1)
		else:
			ones+=1 
	return ans 

print(minFlipsMonoIncr("010110"))