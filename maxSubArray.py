def maxSubArray(n):
	maxSum=0
	for i in range(len(n)):
		if max(n[i],n[i+1])>0:
			maxSum=+










n=input("Enter the array: ")
x=maxSubArray(n)
print (x)

##nums = [-2,1,-3,4,-1,2,1,-5,4]