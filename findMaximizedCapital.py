import heapq
# Approach 1- Greedy
def findMaximizedCapital(k,w,profits,capital): # TC O(n log n) // SC O(n)
	n=len(profits)
	projects=list(zip(capital,profits))
	projects.sort(key=lambda x:x[0])
	pq=[]
	ptr=0
	for i in range(k):
		while ptr<n and projects[ptr][0]<=w:
			heapq.heappush(pq, -projects[ptr][1])
			ptr+=1 

		if not pq: break 

		w+=-heapq.heappop(pq)

	return w 

print(findMaximizedCapital(2,0,[1,2,3],[0,1,1]))

