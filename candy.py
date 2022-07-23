def candy(ratings):
	candies=[1]*len(ratings)
	for i in range(1,len(ratings)):
		if ratings[i-1]<ratings[i]:
			candies[i]=candies[i-1]+1 

	total=candies[len(ratings)-1]

	for i in range(len(ratings)-2,-1,-1):
		if ratings[i+1]<ratings[i]:
			candies[i]=max(candies[i],candies[i+1]+1)

		total+=candies[i]

	return total



print(candy([1,0,2]))
