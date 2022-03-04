#Approach - Brute Force 
def numberOfArithmeticSlices(nums): # TC O(n^2) // SC O(1)
	count=0
	for i in range(len(nums)-2):
		d=nums[i+1]-nums[i]
		for j in range(i+2,len(nums)):
			if nums[j]-nums[j-1]==d:
				count+=1
			else:
				break
	return count 

#Approach- Dynamic Programming 
def numberOfArithmeticSlices1(nums): #TC O(n) // SC O(n)
	dp=[0 for i in range(len(nums))] # TC O(n) // SC O(n) --> 1-D array 
	sum=0
	for i in range(2,len(nums)):
	    if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
	        dp[i]=1+dp[i-1]
	        sum+=dp[i]
	return sum

#Approach- Constant Space Dynamic Programming 
def numberOfArithmeticSlices2(nums): #TC O(n) // SC O(1)
	dp=0
	sum=0
	for i in range(2,len(nums)):
	    if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
	        dp+=1  # As we only need dp[i-1] to keep track of slices, we only track last element 
	        sum+=dp     # instead of 1-D array 
	    else:
	    	dp=0
	return sum

#Approach- Using Formula
def numberOfArithmeticSlices3(nums): # TC O(n) // SC O(1) NOTE-- not working 
	count=0
	sum=0
	for i in range(2,len(nums)):
	    if nums[i]-nums[i-2]==nums[i-1]-nums[i-2]:
	        count+=1
	    else:
	        sum+=(count+1)*(count)//2
	        count=0
	return sum+=(count)*(count+1)//2


print(numberOfArithmeticSlices([1,2,3,4]))
print(numberOfArithmeticSlices1([1,2,3,4,5]))
print(numberOfArithmeticSlices1([7,7,7]))

