#Approach 1- Two Pointers 
def twoSumLessThanK(nums,k): # TC O(n log n)
	nums.sort()
	n=len(nums)
	l,r=0,n-1
	answer=-1
	while l<r:
		total=nums[l]+nums[r]
		if total<k:
			answer=max(answer,total)
			l+=1
		else:
			r-=1
	return answer


#Approach 2- Counting sort 
def twoSumLessThanK1(nums,k): # TC O(n+m) // SC O(m)
	answer=-1
	count=[0]*1001
	for num in nums:
		count[num]+=1

	low=1
	high=1000

	while low<=high:
		if low+high>=k or count[high]==0:
			high-=1
		else:
			if count[low] > (0 if low < high else 1):
				answer=max(answer,low+high)
			low+=1

	return answer

print(twoSumLessThanK([34,23,1,24,75,33,54,8],60))
print(twoSumLessThanK1([34,23,1,24,75,33,54,8],60))