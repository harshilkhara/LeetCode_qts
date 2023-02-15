# Approach 1- School book maths
def addToArrayForm(num,k): # TC O(n) // SC O(n)
	ans=[]
	curr=k
	i=len(num)-1
	while i>=0 or curr>0:
	    if i>=0:
	        curr+=num[i]
	    ans.append(curr%10)
	    curr//=10
	    i-=1
	ans.reverse()
	return ans

print(addToArrayForm([1,2,3,4],56))