# Approach 1- Binary Search
def shipWithinDays(weights,days): # TC O(n log n) // SC O(1)
	def feasible(weights,c,days):
		currentLoad,daysNeeded=0,1
		for weight in weights:
			currentLoad+=weight 
			if currentLoad>c:
				daysNeeded+=1
				currentLoad=weight 

		return daysNeeded<=days 

	l,r=max(weights),sum(weights)
	while l<r:
		mid=l+(r-l)//2
		if feasible(weights,mid,days):
			r=mid 
		else:
			l=mid+1 

	return l 

print(shipWithinDays([1,2,3,4,5,6,7,8,9,10],5))


