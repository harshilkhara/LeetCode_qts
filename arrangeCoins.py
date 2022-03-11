#Approach 1- Binary Search
def arrangeCoins(n): # TC O (log n) // SC O(1)
	l,r=0,n 
	while l<=r:
		mid=(l+r)//2
		coins=mid*(mid+1)//2
		if coins==n:
			return mid 
		elif n < coins: # n is target
			r=mid-1
		else:
			l=mid+1
	return r 

#Approach 2- Math 

def arrangeCoins1(n): # TC O(1) // SC O(1)
	return (int) ((2*n+0.25)**0.5-0.5)


print(arrangeCoins(8))
print(arrangeCoins1(16))

