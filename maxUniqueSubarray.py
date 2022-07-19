#Approach 1 - Brute Force 
def maxUniqueSubarray(nums): # TC O(N^2) // SC O(N)
	seen=set()
	result=0
	for start in range(len(nums)):
		current_sum=0
		seen.clear()
		for end in range(start,len(nums)):
			if nums[end] not in seen:
				current_sum+=nums[end]
				seen.add(nums[end])
		result=max(result,current_sum)
	return result

#Approach - Two Pointers
def maxUniqueSubarray1(nums): # TC (2N)--> (N) // SC O(N)
	seen=set()
	result=0 
	start=0
	current_sum=0
	for end in range(len(nums)):
		while nums[end] in seen:
			seen.remove(nums[start])
			current_sum-=nums[start]
			start+=1

		current_sum+=nums[end]
		seen.add(nums[end])
		result=max(result,current_sum)

	return result

print(maxUniqueSubarray([5,2,1,2,5,2,1,2,5]))
print(maxUniqueSubarray1([4,2,4,5,6]))