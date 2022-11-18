import collections
# Approach 1- HashMap
def mostFrequentEven(nums): # TC O(n) // SC O(n)
	count=collections.Counter(nums)
	ans=-1 
	maxFreq=float("-inf")
	for k,v in count.items():
		if k%2==0:
			if count[k]>maxFreq:
				maxFreq=v  
				ans=k  
			if count[k]==maxFreq:
				ans=min(ans,k)

	return ans 

print(mostFrequentEven([0,1,2,2,4,4,1]))