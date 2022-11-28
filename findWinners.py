# Approach 1- HashMap 
def findWinners(matches): # TC O(n log n) // SC O(n)
	hmap={}
	for winner,loser in matches:
	    hmap[winner]=hmap.get(winner,0)
	    hmap[loser]=hmap.get(loser,0)+1
	   
	zeroLoss=[]
	oneLoss=[]
	for k,v in hmap.items():
	    if v==0:
	        zeroLoss.append(k)
	    if v==1:
	        oneLoss.append(k)

	zeroLoss.sort()
	oneLoss.sort()
	return [zeroLoss,oneLoss]

# Approach 2- Counting with Array
def findWinners1(matches): # TC O(n+k) // SC O(k)
	losses_count = [-1] * 100001

	for winner, loser in matches:
	    if losses_count[winner] == -1:
	        losses_count[winner] = 0
	    if losses_count[loser] == -1:
	        losses_count[loser] = 1
	    else:
	        losses_count[loser] += 1
	    
	answer = [[], []]
	for i in range(100001):
	    if losses_count[i] == 0:
	        answer[0].append(i)
	    elif losses_count[i] == 1:
	        answer[1].append(i)
	        
	return answer

print(findWinners([[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]))
print(findWinners1([[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]))