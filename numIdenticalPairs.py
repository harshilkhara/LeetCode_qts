from collections import defaultdict
class Solution:
# Approach 1- HashMap
	def numIdenticalPairs(self, nums): # TC O(n) SC O(n)
		counter=defaultdict(int)
		ans=0
		for num in nums:
			ans+=counter[num]
			counter[num]+=1

		return ans 

s=Solution()
print(s.numIdenticalPairs([1,2,3,1,1,3]))
