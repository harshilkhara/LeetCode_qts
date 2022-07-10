# Approach 1- Bottom Up DP 
def minCostClimbingStairs(cost): # TC O(N) // SC O(N)
	minCost=[0]*(len(cost)+1)
	for i in range(2,len(minCost)):
		stepOne=minCost[i-1]+cost[i-1]
		stepTwo=minCost[i-2]+cost[i-2]
		minCost[i]=min(stepOne,stepTwo)

	return minCost[-1] 

# Approach 2- Top Down DP (Recursion + memoization) 
def minCostClimbingStairs1(cost): # TC O(N) // SC O(N)
	def minimum_cost(i):
		# Base case, we are allowed to start at either step 0 or step 1
		if i <= 1:
		    return 0

		# Check if we have already calculated minimum_cost(i)
		if i in memo:
		    return memo[i]

		# If not, cache the result in our hash map and return it
		down_one = cost[i - 1] + minimum_cost(i - 1)
		down_two = cost[i - 2] + minimum_cost(i - 2)
		memo[i] = min(down_one, down_two)
		return memo[i]

	memo = {}
	return minimum_cost(len(cost))

# with @lru cache for python3 
from functools import lru_cache
def minCostClimbingStairs2(cost):
	@lru_cache
	def minimum_cost(i):
	    if i <= 1:
	        return 0
	    
	    down_one = cost[i - 1] + minimum_cost(i - 1)
	    down_two = cost[i - 2] + minimum_cost(i - 2)
	    return min(down_one, down_two)

	return minimum_cost(len(cost))

# Approach 3- Bottom Up DP (Space Optimized)

def minCostClimbingStairs3(cost):
	down_one = down_two = 0
	for i in range(2, len(cost) + 1):
	    temp = down_one
	    down_one = min(down_one + cost[i - 1], down_two + cost[i - 2])
	    down_two = temp

	return down_one

print(minCostClimbingStairs([1,4,10,15,20])) 
print(minCostClimbingStairs1([1,4,10,15,20])) 
print(minCostClimbingStairs2([1,4,10,15,20])) 
print(minCostClimbingStairs3([1,4,10,15,20])) 

