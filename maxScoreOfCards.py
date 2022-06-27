def maxScoreOfCards(cardPoints,k):
	n=len(cardPoints)
	frontScore=0 
	rearScore=0
	for i in range(k):
		frontScore+=cardPoints[i]

	maxScore=frontScore 

	for i in range(k-1,-1,-1):
		rearScore+=cardPoints[n-(k-i)]
		frontScore-=cardPoints[i]
		currentScore=rearScore+frontScore
		maxScore=max(maxScore,currentScore)

	return maxScore 

print(maxScoreOfCards([1,2,3,4,5,6,1],4))

