def kthfactor1(n,k):        # TC O(n)   // SC O(1)
	count=1
	for i in range (1,n+1):
		if n%i==0:
			if count==k:
				return i
			count+=1

import math                 
def kthfactor(n,k):      # TC O(sqrt(n)) // SC O(1)
	res,ans=[], []
	for i in range(1, int(math.sqrt(n)+1)):
		if n%i==0:
			if i==n//i:       #nothing but i^2==n: 
				res.append[i]
			else:
				res.append[i]
				ans.insert(0,n//i)
	res.extend(ans)
	if len(res)>=k:
		return res[k-1]
	return -1

# Another approach same TC and SC but with min and max 

def kthfactor2(n,k):
	big,small=[], []
	for i in range(1,int(n**0.5)+1):
		if n%i==0:
			if i==n//i:
				small.append(i)
			else:
				small.append(min(i,n//i))
				big.append(max(i,n//i))
	big.reverse()
	all_factors=small+big
	if len(all_factors)>=k:
		return all_factors[k-1]
	return -1

print(kthfactor(12,3))
print(kthfactor1(12,3))
print(kthfactor2(4,4))
