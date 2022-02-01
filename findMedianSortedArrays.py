def findMedianSortedArrays(nums1,nums2): # TC O(log(min(m,n))) // SC O(1)
	A,B=nums1,nums2
	total=len(nums1)+len(nums2)
	half=total//2

	if len(B)<len(A):
		A,B=B,A 

	l,r=0,len(A)-1

	while True:
		i=(l+r)//2 #A -- mid index value for A
		j=half-i-2 #B -- mid index value for B

		Aleft=A[i] if i>=0 else float('-inf')
		Aright=A[i+1] if (i+1)<len(A) else float('inf')
		Bleft=B[j] if j>=0 else float('-inf')
		Bright=B[j+1] if (j+1)<len(B) else float('inf')

		# partition is correct
		if Aleft <=Bright and Bleft<=Aright:
			# odd 
			if total%2:
				return min(Aright,Bright)
			# even
			return (max(Aleft,Bleft)+min(Aright,Bright))/2
		# partition is not correct
		elif Aleft>Bright:  # Bright is the key
			r=i-1
		else:
			l=i+1

#Approach- Brute Force
def findMedianSortedArrays1(nums1,nums2): # TC O(n log n) // SC O(1)
	res=nums1+nums2
	res.sort()
	if len(res)%2==1:
	    return res[len(res)//2]
	else:
	    A=res[((len(res))//2)-1]
	    B=res[(len(res)//2)]
	    median=(A+B)/2
	    return median

print(findMedianSortedArrays([1,3,8,11,15],[1,5,9,10,13]))
print(findMedianSortedArrays1([1,2,3],[4,5]))
