def sortedSquares(nums): # TC O(n log n) // SC O(n)
	for i in range(len(nums)):
		nums[i]*=nums[i]

	nums.sort()
	return nums 

def sortedSquares1(nums): # TC O(n log n) // SC O(n)
	return sorted(x*x for x in nums)

#Approach- Two Pointers 
def sortedSquares2(nums): # TC O(n) // SC O(n)
	n=len(nums)
	result=[0]*n
	l=0 
	r=n-1
	for i in range(n-1,-1,-1):
		if abs(nums[l])<abs(nums[r]):
			square=nums[r]
			r-=1
		else:
			square=nums[l]
			l+=1
		result[i]=square*square
	return result 

print(sortedSquares([-4,-1,0,3,10]))
print(sortedSquares1([-4,-1,0,3,10]))
print(sortedSquares2([-4,-1,0,3,10]))