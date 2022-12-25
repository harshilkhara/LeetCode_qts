import bisect
# Approach 1- Sort and count 
def answerQueries(nums,queries): # TC O(n.m + n log n) // SC O(n)
	nums.sort()
	ans=[]
	for query in queries:
		count=0 
		for num in nums:
			if query>=num:
				count+=1
				query-=num 
			else:
				break 
		ans.append(count)

	return ans 

# Approach 2- Prefix sum and Binary Search 
def answerQueries1(nums,queries): # TC O((n+m) log n) // SC O(n)
	nums.sort()
	#prefix sum- running sum
	for i in range(1,len(nums)):
		nums[i]+=nums[i-1]

	ans=[]
	for i in range(len(queries)):
		index=bisect.bisect_right(nums,queries[i])
		ans.append(index)

	return ans 

print(answerQueries([4,5,2,1],[3,10,21]))
print(answerQueries1([4,5,2,1],[3,10,21]))

