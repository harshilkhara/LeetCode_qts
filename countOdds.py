# Approach 1- Maths
def countOdds(low,high): # TC O(1) // SC O(1)
	if low%2==0:
		low+=1

	return 0 if low>high else (high-low)//2+1

print(countOdds(3,7))