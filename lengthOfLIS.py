# Approach 1- Brute force and DP 
def lengthOfLIS(nums): # TC O(N^2) // SC O(N)
	dp=[1]*len(nums)
	for i in range(1,len(nums)):
		for j in range(i):
			if nums[i]>nums[j]:
				dp[i]=max(dp[i],dp[j]+1)
	return max(dp)

# Approach 2- Intelligently Build a Subsequence 
def lengthOfLIS1(nums): # TC O(N^2) // SC O(N)
	sub = [nums[0]]
	for num in nums[1:]:
	    if num > sub[-1]:
	        sub.append(num)
	    else:
	        # Find the first element in sub that is greater than or equal to num
	        i = 0
	        while num > sub[i]:
	            i += 1
	        sub[i] = num

	return len(sub)

# Approach 3- Improve with Binary Search (Very much same logic as above)
from bisect import bisect_left
def lengthOfLIS2(nums):
	sub = []
	for num in nums:
	    i = bisect_left(sub, num)

	    # If num is greater than any element in sub
	    if i == len(sub):
	        sub.append(num)

	    # Otherwise, replace the first element in sub greater than or equal to num
	    else:
	        sub[i] = num

	return len(sub)

# Approach 3.1- Improve with binary search but taken from approach 2 (more straight forward)
def lengthOfLIS3(nums): # TC O(n log n) // SC O(N)
	sub = [nums[0]]
	for num in nums[1:]:
	    if num > sub[-1]:
	        sub.append(num)
	    else:
	        i = bisect_left(sub, num)
	        sub[i] = num

	return len(sub)

print(lengthOfLIS([10,9,2,5,3,7,101,18]))
print(lengthOfLIS1([10,9,2,5,3,7,101,18]))
print(lengthOfLIS2([10,9,2,5,3,7,101,18]))
print(lengthOfLIS3([10,9,2,5,3,7,101,18]))
