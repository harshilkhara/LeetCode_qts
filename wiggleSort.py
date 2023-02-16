# Approach 1- 
def wiggleSort(nums):
	nums.sort()
	for i in range(1,len(nums)-1,2):
		nums[i],nums[i+1]=nums[i+1],nums[i]

	return nums


# Approach 2- Kinda bubble sort like 
def wiggleSort1(nums): # TC O(n) SC O(1)
	for i in range(1,len(nums)):
	    if i%2:
	        if nums[i]<nums[i-1]:
	            nums[i],nums[i-1]=nums[i-1],nums[i]
	    else:
	        if nums[i]>nums[i-1]:
	            nums[i],nums[i-1]=nums[i-1],nums[i]
	return nums

print(wiggleSort([3,5,2,1,4,6]))
print(wiggleSort1([3,5,2,1,4,6]))