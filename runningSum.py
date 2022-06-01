def runningSum(nums): # TC O(n) // SC O(1)
	for i in range(1,len(nums)):
		nums[i]+=nums[i-1]
	return nums 

def runningSum1(nums): # TC O(n) // SC O(n)
	dp=[0]*len(nums)
	dp[0]=nums[0]
	for i in range(1,len(nums)):
		dp[i]=dp[i-1]+nums[i]
	return dp 

def runningSum2(nums):
	return [sum(nums[:i+1]) for i in range(len(nums))]

print(runningSum([1,2,3,4]))
print(runningSum1([1,1,1,1,1]))
print(runningSum2([3,1,2,10,1]))
