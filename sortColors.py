# Approach - Three pointers, One pass 
def sortColors(nums): # TC O(N) // SC O(1)
	"""
	Dutch National Flag problem solution.
	"""
	# for all idx < p0 : nums[idx < p0] = 0
	# curr is an index of element under consideration
	p0 = curr = 0
	# for all idx > p2 : nums[idx > p2] = 2
	p2 = len(nums) - 1

	while curr <= p2:
	    if nums[curr] == 0:
	        nums[p0], nums[curr] = nums[curr], nums[p0]
	        p0 += 1
	        curr += 1
	    elif nums[curr] == 2:
	        nums[curr], nums[p2] = nums[p2], nums[curr]
	        p2 -= 1
	    else:
	        curr += 1
	return nums 

print(sortColors([2,0,2,1,1,2,0]))