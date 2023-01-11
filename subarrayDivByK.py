# Approach 1- Prefix sum and counting the remainders
def subarrayDivByK(nums,k): # TC O(n) // SC O(n)
	prefixMod,result=0,0 
	n=len(nums)
	remainders=[0]*k 
	remainders[0]=1 
	for num in nums:
		prefixMod=(prefixMod+num%k+k)%k 
		result+=remainders[prefixMod]
		remainders[prefixMod]+=1 
	return result 

print(subarrayDivByK([1,11,12,23,5],2))