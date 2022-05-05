#Approach 1- Shift non-zero elements before lastNoneZero and then append 0 after lastNoneZero
def moveZeros(nums): # TC O(n) // SC O(1)
	lastNonZero=0 
	for i in range(len(nums)):
		if nums[i]!=0:
			nums[lastNonZero]=nums[i]
			lastNonZero+=1
	for i in range(lastNonZero,len(nums)):
		nums[i]=0
	return nums 
	
# Approach 2 - Two pointers with while loop 
def moveZeros1(nums):   # TC O(n) // SC O(1)
	l,r=0,0
	while r <len(nums):
		if nums[r]!=0:
			nums[l],nums[r]=nums[r],nums[l]
			l+=1
		r+=1
	return nums

# Same Two pointers approach but with for loop
def moveZeros2(nums): # TC O(n) // SC O(1)
	l=0
	for r in range(len(nums)):
		if nums[r]!=0:
			nums[l],nums[r]=nums[r],nums[l]
			l+=1
	return nums

#Approach 3- slicing, very similar to approach 1 concept
def moveZeros3(nums): # TC O(n) // SC O(1)
	zeros=nums.count(0)
	nums[:]=[i for i in nums if i!=0]
	nums+=[0]*zeros
	return nums

#Approach 4- Sorting 
def moveZeros4(nums): # TC O(n log n) // SC O(1)
	nums.sort(key=lambda n:n==0)
	return nums

print(moveZeros([0,1,0,3,12]))
print(moveZeros1([0,1,0,3,12]))
print(moveZeros2([0,1,0,3,12]))
print(moveZeros3([0,1,0,3,12]))
print(moveZeros3([1,0,6,5,0]))
print(moveZeros4([1,0,6,5,0]))