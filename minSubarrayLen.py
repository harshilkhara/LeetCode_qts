'''
Approach- Sliding Window 

'''
def minSubarrayLen(target,nums): # TC O(2n) --> TC O(n) // SC O(1)
	sum,l=0,0
	ans=float('inf')
	for r in range(len(nums)):
		sum+=nums[r]
		while sum>=target:
			ans=min(ans,r-l+1)
			sum-=nums[l]
			l+=1
	return 0 if ans==float('inf') else ans 

print(minSubarrayLen(7,[2,3,1,2,4,3]))