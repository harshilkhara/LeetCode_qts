#Approach 1- Merge and Sort 
def mergeSortedArrays(nums1,m,nums2,n): # TC O((n+m) log(n+m)) // SC O(n)
	for i in range(n):
		nums1[i+m]=nums2[i]

	nums1.sort()
	return nums1 

'''
Approach 2- Three pointers 

Algorithm

The simplest implementation would be to make a copy of the values in nums1, called nums1Copy, 
and then use two read pointers and one write pointer to read values from nums1Copy and nums2 
and write them into nums1.

Initialize nums1Copy to be a new array containing the first m values of nums1.
Initialize read pointer p1 to the beginning of nums1Copy.
Initialize read pointer p2 to the beginning of nums2.
Initialize write pointer p to the beginning of nums1.
While p is still within nums1:
	If nums1Copy[p1] exists and is less than or equal to nums2[p2]:
		Write nums1Copy[p1] into nums1[p], and increment p1 by 1.
	Else
		Write nums2[p2] into nums1[p], and increment p2 by 1.
	Increment p by 1.

'''
def mergeSortedArrays1(nums1,m,nums2,n): # TC O(n+m) // SC O(m)
	# Make a copy of the first m elements of nums1.
	nums1_copy = nums1[:m] 

	# Read pointers for nums1Copy and nums2 respectively.
	p1 = 0
	p2 = 0

	# Compare elements from nums1Copy and nums2 and write the smallest to nums1.
	for p in range(n + m): #p is the write pointer 
	    # We also need to ensure that p1 and p2 aren't over the boundaries
	    # of their respective arrays.
	    if p2 >= n or (p1 < m and nums1_copy[p1] <= nums2[p2]):
	        nums1[p] = nums1_copy[p1] 
	        p1 += 1
	    else:
	        nums1[p] = nums2[p2]
	        p2 += 1
	return nums1

'''
Approach 3- Three pointers (Start from the end)

'''
def mergeSortedArrays2(nums1,m,nums2,n): # TC O(n+m) // SC O(1)
	# Set p1 and p2 to point to the end of their respective arrays.
	p1 = m - 1
	p2 = n - 1

	# And move p backwards through the array, each time writing
	# the smallest value pointed at by p1 or p2.
	for p in range(n + m - 1, -1, -1): # p is the write pointer 
	    if p2 < 0:
	        break
	    if p1 >= 0 and nums1[p1] > nums2[p2]:
	        nums1[p] = nums1[p1]
	        p1 -= 1
	    else:
	        nums1[p] = nums2[p2]
	        p2 -= 1
	return nums1

print(mergeSortedArrays([1,2,3,0,0,0],3,[2,5,6],3))
print(mergeSortedArrays1([1,2,3,0,0,0],3,[2,5,6],3))
print(mergeSortedArrays2([2,0],1,[1],1))
