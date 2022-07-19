def checkPossibility(nums): # TC O(N) // SC O(1)
	numViolations=0
	for i in range(1,len(nums)):
		if nums[i-1]>nums[i]:
			if numViolations==1:
				return False
			
			numViolations+=1

			if i<2 or nums[i-2]<=nums[i]:
				nums[i-1]=nums[i]
			else:
				nums[i]=nums[i-1]

	return True 

print(checkPossibility([4,2,1]))
print(checkPossibility([4,2,3]))

