# Approach 1- Count the no. of consecutive 0's at each index
def zeroFilledSubarray(nums): # TC O(n) // SC O(1)
	ans,zeroSubarray=0,0
	for num in nums:
		if num==0:
			zeroSubarray+=1
		else:
			zeroSubarray=0 
		ans+=zeroSubarray
	return ans 

print(zeroFilledSubarray([1,3,0,0,2,0,0,4]))