# Approach 1- Linear Scan 
# Think of LIS too here 
def increasingTriplet(nums): # TC O(n) // SC O(1)
	first_num = float("inf")
	second_num = float("inf")
	for n in nums:
	    if n <= first_num:
	        first_num = n
	    elif n <= second_num:
	        second_num = n
	    else:
	        return True
	return False

print(increasingTriplet([1,2,3,4,5]))