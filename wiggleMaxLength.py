# Approach 1- DP 
def wiggleMaxLength(nums): # TC O(N) // SC O(1)
	if len(nums)<2: return len(nums)
	up=down=1 
	for i in range(1,len(nums)):
		if nums[i]>nums[i-1]:
			up=down+1
		elif nums[i]-nums[i-1]:
			down=up+1

	return max(down,up)

# Approach 2- Greedy Method # TC O(N) // SC O(1)
def wiggleMaxLength1(nums):
	if len(nums)<2: return len(nums)
	prevdiff=nums[1]-nums[0]
	count= 2 if prevdiff!=0 else 1 
	for i in range(2,len(nums)):
		diff=nums[i]-nums[i-1]
		if (diff>0 and prevdiff<=0 or diff < 0 and prevdiff>=0):
			count+=1
			prevdiff=diff 

	return count

print(wiggleMaxLength([1,7,4,9,2,5]))
print(wiggleMaxLength1([1,7,4,9,2,5]))

