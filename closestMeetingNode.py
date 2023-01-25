from collections import deque
# Approach 1- BFS 
def closestMeetingNode(edges,node1,node2): # TC O(n) // SC O(n)
	n=len(edges)
	dist1,dist2=[float('inf')]*n,[float('inf')]*n

	def bfs(startNode,dist,edges):
	    q=deque()
	    q.append(startNode)
	    visited=[False]*n
	    dist[startNode]=0
	    while q:
	        node=q.popleft()
	        if visited[node]:
	            continue
	        
	        visited[node]=True
	        neighbor=edges[node]
	        if neighbor!=-1 and not visited[neighbor]:
	            dist[neighbor]=dist[node]+1
	            q.append(neighbor)

	bfs(node1,dist1,edges)
	bfs(node2,dist2,edges)

	minDist=-1
	minDistTillNow=float('inf')
	for currNode in range(0,n):
	    if minDistTillNow>max(dist1[currNode],dist2[currNode]):
	        minDist=currNode
	        minDistTillNow=max(dist1[currNode],dist2[currNode])
	return minDist

print(closestMeetingNode([2,2,3,-1],0,1))