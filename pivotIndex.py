def pivotIndex(nums):                # TC O(n) // SC O(1)
	s=sum(nums)
	leftsum=0
	for i,x in enumerate(nums):
		if leftsum==(s-nums[i]-leftsum):
			return i
		leftsum+=x 
	return -1

print(pivotIndex([1,7,3,6,5,6]))