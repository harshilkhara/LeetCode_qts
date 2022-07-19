# Closely related to maxSubArraylen

# Approach 1- Two Pointers (Direct Approach)  
def minOperations(nums,x): # TC O(2N) --> (N) // SC O(N)
	current = sum(nums)
	n = len(nums)
	mini = float('inf')
	left = 0

	for right in range(n):
	    # sum([0,..,left) + (right,...,n-1]) = x
	    current -= nums[right]
	    # if smaller, move `left` to left
	    while current < x and left <= right:
	        current += nums[left]
	        left += 1
	    # check if equal
	    if current == x:
	        mini = min(mini, (n-1-right)+left)

	return mini if mini != float('inf') else -1

# Approach 2- Two Pointers (Indirect Approach) 
# It is sliding window in a nutshell
def minOperations1(nums,x): # TC O(2n) --> O(N) // SC O(n)
	total = sum(nums)
	n = len(nums)
	maxi = -1
	left = 0
	current = 0

	for right in range(n):
	    # sum([left ,..., right]) = total - x
	    current += nums[right]
	    # if larger, move `left` to left
	    while current > total-x and left <= right:
	        current -= nums[left]
	        left += 1
	    # check if equal
	    if current == total-x:
	        maxi = max(maxi, right-left+1)

	return n-maxi if maxi != -1 else -1

print(minOperations([1,3,2,3,5,1,7],14))
print(minOperations1([1,1,4,2,3],5))