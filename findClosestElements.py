import collections
import bisect
#Approach 1- Custom sorting (brute force)
def findClosestElements(arr,k,x): # TC O(n log n + k log k) // SC O(n)
	sorted_arr=sorted(arr, key=lambda nums:abs(x-nums))

	result=sorted_arr[:k]

	return sorted(result)

# Approach 2- Binary Search + Sliding window 
def findClosestElements1(arr,k,x): # TC O(log n + k) // SC O(1)
	if len(arr)==k: return arr 

	left=bisect.bisect_left(arr,x)-1
	right=left+1 

	while right-left-1<k:
		if left==-1:
			right+=1 

		if right==len(arr) or abs(arr[left]-x)<=abs(arr[right]-x):
			left-=1
		else:
			right+=1 


	return arr[left+1:right]

#Approach 3- Binary search to find the left bound
def findClosestElements2(arr,k,x): # TC O(log(n-k)+k) // SC O(1) 
    # Initialize binary search bounds
    left = 0
    right = len(arr) - k
    
    # Binary search against the criteria described
    while left < right:
        mid = (left + right) // 2
        if x - arr[mid] > arr[mid + k] - x:
            left = mid + 1
        else:
            right = mid

    return arr[left:left + k]

print(findClosestElements([1,2,3,4,5],4,3))
print(findClosestElements1([1,2,3,4,5],4,3))
print(findClosestElements2([1,2,3,4,5],4,3))