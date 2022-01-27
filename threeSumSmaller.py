'''
Very inspired from threeSum.py

Approach- Two Pointers 

'''
def threeSumSmaller(nums,target): # TC O(log n + n^2) --> TC O(n^2) // SC O(1) or O(logn) or O(n)
	sum=0 
	nums.sort()
	for i in range(len(nums)):
	    sum+=twoSumII(nums,i,target-nums[i])
	return sum

def twoSumII(nums,i,target):
	sum=0
	l,r=i+1,len(nums)-1
	while l < r:
	    if (nums[l]+nums[r] < target):
	        sum+=r-l
	        l+=1
	    else:
	        r-=1
	return sum
'''
 The following below is the same approach but with only 1 function & better, faster implementaion.

 '''
def threeSumSmaller1(nums,target):# TC O(n^2) Fastest one on leetcode though & similar to threeSum.py
	nums.sort()
	count = 0
	for index in range(len(nums)):
	    val = target - nums[index]
	    start = 0
	    end = index - 1
	    while start < end:
	        if nums[start] + nums[end] < val:
	            count += end - start
	            start += 1
	        elif start == 0 and end == 1 and nums[start] + nums[end] >= val:
	                return count
	        else:
	            end -= 1            
	return count
             
print(threeSumSmaller([-2,0,1,3],2))
print(threeSumSmaller1([3,5,2,8,1],8))