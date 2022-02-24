'''
Approach- One pass Binary search

'''
def searchRotatedArray(nums,target): # TC O(log n) // SC O(1)
	start, end = 0, len(nums) - 1
	while start <= end:
	    mid = start + (end - start) // 2
	    if nums[mid] == target:
	        return mid
	    elif nums[mid] >= nums[start]:
	        if target >= nums[start] and target < nums[mid]:
	            end = mid - 1
	        else:
	            start = mid + 1
	    else:
	        if target <= nums[end] and target > nums[mid]:
	            start = mid + 1
	        else:
	            end = mid - 1
	return -1

# Same approach but with combined if else condition 

def searchRotatedArray1(nums,target): # TC O(log n) // SC O(1)
	start, end = 0, len(nums) - 1
	while start <= end:
	    mid = start + (end - start) // 2
	    if nums[mid] == target:
	        return mid
	    elif nums[mid] >= nums[start]:#Left side of array is sorted w respect to mid i.e.(not rotated)
	        if nums[start]<=target<nums[mid]:
	            end = mid - 1
	        else:
	            start = mid + 1
	    else:                      #Right side of array is sorted w respect to mid i.e.(not rotated)
	        if nums[mid]<target<=nums[end]:
	            start = mid + 1
	        else:
	            end = mid - 1
	return -1


print(searchRotatedArray([4,5,6,7,0,1,2],0))
print(searchRotatedArray1([4,5,6,7,0,1,2],7))