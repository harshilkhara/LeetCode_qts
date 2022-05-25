# Very much inspired from lengthOfLIS.py
# Approach 1- Sort + Longest Increasing Subsequence (LIS)
from bisect import bisect_left
def maxEnvelopes(arr): # TC O(n log n) // SC O(n)
	arr.sort(key=lambda x: (x[0], -x[1]))
	print(arr)
	
	def lis(nums):
	    dp = []
	    for i in range(len(nums)):
	        idx = bisect_left(dp, nums[i])
	        if idx == len(dp):
	            dp.append(nums[i])
	        else:
	            dp[idx] = nums[i]
	    return len(dp)
	# extract the second dimension and run the LIS
	return lis([i[1] for i in arr])

print(maxEnvelopes([[5,4],[6,4],[6,7],[2,3]]))
