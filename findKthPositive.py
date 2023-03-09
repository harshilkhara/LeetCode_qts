class Solution:
# Approach 1- Scanning the array (Brute force)
	def findKthPositive(self,arr,k): # TC O(n) // SC O(1)
		if k<=arr[0]-1: return k 
		k-=arr[0]-1
		n=len(arr)
		for i in range(n-1):
			currMissing=arr[i+1]-arr[i]-1 
			if k<=currMissing:
				return arr[i]+k 
			k-=currMissing 

		return arr[-1]+k 

# Approach 2- Binary Search
	def findKthPositive1(self, arr, k): # TC O(log n) // SC O(1)
	    left, right = 0, len(arr) - 1
	    while left <= right:
	        pivot = (left + right) // 2
	        # If number of positive integers
	        # which are missing before arr[pivot]
	        # is less than k -->
	        # continue to search on the right.
	        if arr[pivot] - pivot - 1 < k:
	            left = pivot + 1
	        # Otherwise, go left.
	        else:
	            right = pivot - 1

	    # At the end of the loop, left = right + 1,
	    # and the kth missing is in-between arr[right] and arr[left].
	    # The number of integers missing before arr[right] is
	    # arr[right] - right - 1 -->
	    # the number to return is
	    # arr[right] + k - (arr[right] - right - 1) = k + left
	    return left + k

s=Solution()
print(s.findKthPositive([2,3,4,7,11],5))
print(s.findKthPositive1([2,3,4,7,11],5))
