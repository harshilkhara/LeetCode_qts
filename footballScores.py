# Asked in goldman sachs interview 
# https://leetcode.com/discuss/interview-question/1930478/football-scores-hackerrank-question
def footballScores(teamA,teamB):
	teamA.sort()
	answer=[]
	for i in range(len(teamB)):
		l,r=0,len(teamA)-1
		while l<=r:
			mid=(l+r)//2
			if teamA[mid]>teamB[i]:
				r=mid-1
			else:
				l=mid+1
		answer.append(l)

	return answer 

print(footballScores([2,10,5,4,8],[3,1,7,8]))