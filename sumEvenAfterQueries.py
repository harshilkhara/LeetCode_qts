def sumEvenAfterQueries(nums,queries):
	s= sum(x for x in nums if x%2==0)
	ans=[]
	for val,idx in queries:
		if nums[idx]%2==0:
			s-=nums[idx]
		nums[idx]+=val
		if nums[idx]%2==0:
			s+=nums[idx]
		ans.append(s)
		
	return ans

print(sumEvenAfterQueries([1,2,3,4],[[1,0],[-3,1],[-4,0],[2,3]]))