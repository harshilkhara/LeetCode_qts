# Approach 1- Iterative DFS [using explicit stack]
def canVisitAllRooms(rooms): # TC O(N+E) // SC O(N)
	seen=[False]*len(rooms)
	stack=[]
	seen[0]=True 
	stack.append(0)
	while stack:
		room=stack.pop()
		for key in rooms[room]:
			if not seen[key]:
				seen[key]=True
				stack.append(key)

	for visited in seen:
		if not visited:
			return False 
	return True 

	# return all(seen) Return true iff we've visited every room

print(canVisitAllRooms([[1],[2],[3],[]]))
