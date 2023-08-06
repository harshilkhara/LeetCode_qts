class Solution:
# Approach 1- Balance 
	def minAddToMakeValid(self, s): # TC O(n) SC O(1)
		ans,bal=0,0
		for c in s:
			bal+=1 if c=='(' else -1 
			if bal==-1:
				bal+=1
				ans+=1

		return ans+bal 

s=Solution()
print(s.minAddToMakeValid("(())))("))
