# Very similar to deleteAndEarn.py 

#Approach 1- Recursion with memoization 
def rob(nums): # TC O(n) // SC O(n)
	# No more houses left to examine.
	memo={}

	def robFrom(i,nums):
		if i >= len(nums):
		    return 0
		# Return cached value.
		if i in memo:
		    return memo[i]
		# Recursive relation evaluation to get the optimal answer.
		ans = max(robFrom(i + 1, nums), robFrom(i + 2, nums) + nums[i])
		
		# Cache for future use.
		memo[i] = ans
		return ans

	return robFrom(0,nums)

#Approach 2- Dynamic Programming 
def rob1(nums): # TC O(n) // SC O(n)
	# Special handling for empty case.
	if not nums:
	    return 0

	maxRobbedAmount = [None for _ in range(len(nums) + 1)]
	N = len(nums)

	# Base case initialization.
	maxRobbedAmount[N], maxRobbedAmount[N - 1] = 0, nums[N - 1]

	# DP table calculations.
	for i in range(N - 2, -1, -1):

	    # Same as recursive solution.
	    maxRobbedAmount[i] = max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i])

	return maxRobbedAmount[0]    

#Approach 3- Optimized Dynamic Programming 
def rob2(nums): # TC O(n) // SC O(1)
	# Special handling for empty case.
	if not nums:
	    return 0

	N = len(nums)

	rob_next_plus_one = 0
	rob_next = nums[N - 1]

	# DP table calculations.
	for i in range(N - 2, -1, -1):

	    # Same as recursive solution.
	    current = max(rob_next, rob_next_plus_one + nums[i])

	    # Update the variables
	    rob_next_plus_one = rob_next
	    rob_next = current

	return rob_next

#Approach- From beginning of array to end  like deleteAndEarn.py Approach 2 
def rob3(nums):    # TC O(n) // SC O(n)
	if len(nums)==1:
		return nums[0]
	maxRob=[0]*len(nums)
	maxRob[0]=nums[0]
	maxRob[1]=max(nums[0],nums[1])

	for i in range(2,len(nums)):
		maxRob[i]=max(maxRob[i-1],maxRob[i-2]+nums[i])

	return maxRob[-1]

print(rob([1,2,3,1]))
print(rob1([2,7,9,3,1]))
print(rob2([2,1,1,2]))
print(rob3([2,7,9,3,1]))