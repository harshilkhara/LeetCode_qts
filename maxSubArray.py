def maxSubArray(n):
	total_sum=max_sum= n[0]

	for i in n[1:]:
		total_sum=max(i,total_sum+i)
		max_sum=max(max_sum,total_sum)
	return max_sum

            
n = [-2,1,-3,4,-1,2,1,-5,4]
x=maxSubArray(n)
print (x)


