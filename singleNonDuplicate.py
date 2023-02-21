# Approach 1- Bit Manipulation- XOR 
def singleNonDuplicate(nums): # TC O(n) // SC O(1)
	ans=0
	for num in nums:
		ans^=num  

	return ans 

# Approach 2- Linear Scan
def singleNonDuplicate1(nums): # TC O(n) // SC O(1)
	for i in range(0, len(nums) - 2, 2):
	    if nums[i] != nums[i + 1]:
	        return nums[i]
	return nums[-1]

# Approach 3- Binary Search
def singleNonDuplicate2(nums): # TC O(log n) // SC O(1)
	lo = 0
	hi = len(nums) - 1   
	while lo < hi:
	    mid = lo + (hi - lo) // 2
	    halves_are_even = (hi - mid) % 2 == 0
	    if nums[mid + 1] == nums[mid]:
	        if halves_are_even:
	            lo = mid + 2
	        else:
	            hi = mid - 1
	    elif nums[mid - 1] == nums[mid]:
	        if halves_are_even:
	            hi = mid - 2
	        else:
	            lo = mid + 1
	    else:
	        return nums[mid]
	return nums[lo]


# Approach 4- Binary search only on even index and reducing the search space 
def singleNonDuplicate3(nums): # TC O(log n) // SC O(1)
	lo = 0
	hi = len(nums) - 1
	while lo < hi:
	    mid = lo + (hi - lo) // 2
	    if mid % 2 == 1:
	        mid -= 1
	    if nums[mid] == nums[mid + 1]:
	        lo = mid + 2
	    else:
	        hi = mid
	return nums[lo]

print(singleNonDuplicate([1,1,2,3,3,4,4,8,8]))
print(singleNonDuplicate1([1,1,2,3,3,4,4,8,8]))
print(singleNonDuplicate2([1,1,2,3,3,4,4,8,8]))
print(singleNonDuplicate3([1,1,2,3,3,4,4,8,8]))