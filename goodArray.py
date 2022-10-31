# Asked in Goldman Sachs interview
# https://www.desiqna.in/6085/goldman-coding-question-solution-engineering-campus-program
def goodArray(n,queries): #TC O(n*m) // SC O(n)
	equivalentBinary=[]
	goodArray=[]
	while(n>0):
		equivalentBinary.append(n%2);
		n=n//2

	for i in range(len(equivalentBinary)):
		if(equivalentBinary[i]==1):
			goodArray.append(1<<i)
			#goodArray.append(pow(2,i))

	print(goodArray)
	answer=[]
	for query in queries:
		l=query[0];
		r=query[1];
		m=query[2];
		through=1
		while l<=r:
			through*=goodArray[l-1]
			l+=1

		answer.append(through%m)

	return answer 


print(goodArray(6,[[1,2,4],[2,2,8],[1,1,4]]))
print(goodArray(26,[[1,2,1009],[3,3,5]]))
print(goodArray(12,[[1,2,84],[2,2,3]]))