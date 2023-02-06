# Approach 1- Array Iteration
def shuffleArray(nums,n): # TC O(n) // SC O(n) 
	ans=[0]*(2*n)
	for i in range(n):
		ans[2*i]=nums[i]
		ans[2*i+1]=nums[n+i]

	return ans 

# Approach 1- Array Iteration
def shuffleArray1(nums,n): # TC O(n) // SC O(n) 
	ans=[0]*(2*n)
	l,r=0,n
	index=0 
	while l<n:
		ans[index]=nums[l]
		index+=1
		l+=1
		ans[index]=nums[r]
		index+=1
		r+=1

	return ans

# Approach 2- In place filling
def shuffleArray2(nums,n): # TC O(n) // SC O(1)
	# Store each y(i) with respective x(i).
	for i in range(n, 2 * n):
	    secondNum = nums[i] << 10
	    nums[i - n] |= secondNum

	# '0000000000 1111111111' in decimal.
	allOnes = int(pow(2, 10)) - 1

	# We will start putting all numbers from the end, 
	# as they are empty places.
	for i in range(n - 1, -1, -1):
	    # Fetch both the numbers from the current index.
	    secondNum = nums[i] >> 10
	    firstNum = nums[i] & allOnes
	    nums[2 * i + 1] = secondNum
	    nums[2 * i] = firstNum
	return nums

print(shuffleArray([2,5,1,4,1,7],3))
print(shuffleArray1([2,5,1,4,1,7],3))
print(shuffleArray1([2,5,1,4,1,7],3))