def subarraySum(nums,k): # TC O(n^2) // SC O(1) NOTE- It times out though.
	n=len(nums)
	count=0
	for i in range(n):
		sum=0
		for j in range(i,n):
			sum+=nums[j]
			if sum == k:
				count+=1
	return count

def subarraySum1(nums,k):  # TC O(n) // SC O(n)
	sum=0
	count=0
	hashmap={0:1}
	for i in nums:
		sum+=i
		if sum-k in hashmap:
			count+=hashmap[sum-k]
		if sum in hashmap:
			hashmap[sum]+=1
		else:
			hashmap[sum]=1
	return count

print(subarraySum([1,2,3],3))
print(subarraySum1([1,1,1],2))
print(subarraySum1([-1,-1,1],0))
print(subarraySum1([3,4,7,2,-3,1,4,2],7))