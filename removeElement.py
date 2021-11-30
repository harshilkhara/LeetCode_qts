def removeElement(nums,key): # TC O(n) // SC O(1)
	nextElement=0
	for i in range (len(nums)):
		if nums[i]!=key:
			nums[nextElement]=nums[i]
			nextElement+=1
	return nextElement

print(removeElement([3,2,3,6,3,10,9,3],3))

'''
Problem: Given an unsorted array of numbers and a target ‘key’, 
remove all instances of ‘key’ in-place and return the 
new length of the array.

Solution: This problem is quite similar to our parent 
problem that is removeDuplicate problem. We can follow 
a two-pointer approach and shift numbers left upon 
encountering the ‘key’.
'''