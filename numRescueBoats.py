# Approach 1- Two Pointers 
def numRescueBoats(people,limit): # TC O(n log n) // SC O(n) --> space used for sorting algorithm
	people.sort() # TC O(n log n)
	i,j=0,len(people)-1
	ans=0
	while i<=j:
	    ans+=1
	    if people[i]+people[j]<=limit:
	        i+=1
	    j-=1
	return ans 

print(numRescueBoats([3,2,2,1],3))
