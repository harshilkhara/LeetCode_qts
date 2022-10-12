# Approach 1- Sorting 
# The length of any side of a triangle is shorter than the sum of the other two sides
# i.e. c<a+b 
def largestPerimeter(nums): # TC O(n log n) // SC O(n) or O(log n) depending on sorting algo it uses
	nums.sort()
	for i in range(len(nums)-3,-1,-1):
		if nums[i]+nums[i+1]>nums[i+2]:
			return nums[i]+nums[i+1]+nums[i+2] 

	return 0

print(largestPerimeter([1,2,3]))
print(largestPerimeter([2,2,3]))