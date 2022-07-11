# Approach 1- Linear Scan 
def findPeakElement(nums): # TC O(N) // SC O(1)
	for i in range(len(nums)):
		if nums[i]>nums[i+1]:
			return i 

	return len(nums)-1 

def findPeakElement1(nums):
	l=0
	r=len(nums)-1 
	while l<r:
		mid=(l+r)//2
		if nums[mid]>nums[mid+1]: # nums[mid+1] is target 
			r=mid 
		else:
			l=mid+1

	return l 

print(findPeakElement([1,2,3,1]))
print(findPeakElement1([1,2,3,1]))