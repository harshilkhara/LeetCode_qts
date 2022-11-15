# Approach 1- DFS 
def equationsPossible(equations): # TC O(max(N,size of alphabet set of variables))-> TC O(N)
	graph = [[] for _ in range(26)] # SC O(max(N,size of alphabet set of variables))-> SC O(N)

	for eqn in equations:
	    if eqn[1] == '=':
	        x = ord(eqn[0]) - ord('a')
	        y = ord(eqn[3]) - ord('a')
	        graph[x].append(y)
	        graph[y].append(x)

	color = [-1] * 26

	# mark the color of node as c
	def dfs(node, c):
	    if color[node] == -1:
	        color[node] = c
	        for nei in graph[node]:
	            dfs(nei, c)

	for i in range(26):
	    if color[i] == -1:
	        dfs(i, i)

	for eqn in equations:
	    if eqn[1] == '!':
	        x = ord(eqn[0]) - ord('a')
	        y = ord(eqn[3]) - ord('a')
	        if color[x] == color[y]:
	            return False
	return True

# Approach 2- Union Find 

def equationsPossible1(equations):
	root = list(range(26))

	def find(x):
	    if x != root[x]:
	        root[x] = find(root[x])
	    return root[x]

	def union(x, y):
	    x, y = find(x), find(y)
	    root[x] = y

	for eqn in equations:
	    if eqn[1] == '=':
	        x, y = ord(eqn[0])-ord('a'), ord(eqn[3])-ord('a')
	        union(x, y)

	for eqn in equations:
	    if eqn[1] == '!':
	        x, y = ord(eqn[0])-ord('a'), ord(eqn[3])-ord('a')
	        if find(x) == find(y):
	            return False
	return True

print(equationsPossible(["a==b","a!=b"]))
print(equationsPossible1(["a==b","a!=b"]))
