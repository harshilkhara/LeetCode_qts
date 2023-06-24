class Solution:
# Approach 1- DP (Bottom-Up)
	def longestArithSeqLength(self, nums): # TC O(n^2) // SC O(n^2)
		dp={}
		for right in range(len(nums)):
			for left in range(right):
				diff=nums[left]-nums[right]
				dp[(right, diff)]=dp.get((left, diff),1)+1

		return max(dp.values())

s=Solution()
print(s.longestArithSeqLength([3,6,9,12]))