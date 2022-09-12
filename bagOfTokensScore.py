# Approach 1- Two Pointers 
def bagOfTokensScore(tokens,power): # TC O(n log n) // SC O(n) ---> timsort
	tokens.sort()
	l,r=0,len(tokens)-1
	points,ans=0,0 
	while l<=r and (power>=tokens[l] or points>0):
		while l<=r and power>=tokens[l]:
			power-=tokens[l]
			l+=1
			points+=1

		ans=max(ans,points)

		if l<=r and points>0:
			power+=tokens[r]
			r-=1
			points-=1

	return ans 

print(bagOfTokensScore([100,200,300,400],200))