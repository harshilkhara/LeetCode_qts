def findSubsequences(nums): # TC O(2^n. n) // SC O(2^n. n)
	
	def backtrack(nums,idx,sub,ans):
		if len(sub)>1:
			ans.add(tuple(sub))

		for i in range(idx,len(nums)):
			if not sub or sub[-1]<=nums[i]:
				sub.append(nums[i])
				backtrack(nums,i+1,sub,ans)
				sub.pop()


	ans=set()
	sub=[]
	backtrack(nums,0,sub,ans)
	return set(ans)

print(findSubsequences([4,6,7,7]))