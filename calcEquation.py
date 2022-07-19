# Approach 1- Path search in graph 

from collections import defaultdict

def calcEquation(equations,values,queries):   # TC O(M*N) // SC O(N)  M --> no. of queries
	graph = defaultdict(defaultdict)

	def backtrack_evaluate(curr_node, target_node, acc_product, visited):
	    visited.add(curr_node)
	    ret = -1.0
	    neighbors = graph[curr_node]
	    if target_node in neighbors:              # goal 
	        ret = acc_product * neighbors[target_node]
	    else:
	        for neighbor, value in neighbors.items():
	            if neighbor in visited:
	                continue
	            ret = backtrack_evaluate(
	                neighbor, target_node, acc_product * value, visited)
	            if ret != -1.0:
	                break
	    visited.remove(curr_node)  # backtrack
	    return ret

	# Step 1). build the graph from the equations
	for (dividend, divisor), value in zip(equations, values): # TC O(N)
	    # add nodes and two edges into the graph
	    graph[dividend][divisor] = value
	    graph[divisor][dividend] = 1 / value

	# Step 2). Evaluate each query via backtracking (DFS)
	#  by verifying if there exists a path from dividend to divisor
	results = []
	for dividend, divisor in queries:
	    if dividend not in graph or divisor not in graph:
	        # case 1): either node does not exist
	        ret = -1.0
	    elif dividend == divisor:
	        # case 2): origin and destination are the same node
	        ret = 1.0
	    else:
	        visited = set()
	        ret = backtrack_evaluate(dividend, divisor, 1, visited)
	    results.append(ret)

	return results

# Approach 2- Union-Find with Weights 
def calcEquation1(equations,values,queries):
	gid_weight = {}

	def find(node_id):
	    if node_id not in gid_weight:
	        gid_weight[node_id] = (node_id, 1)
	    group_id, node_weight = gid_weight[node_id]
	    # The above statements are equivalent to the following one
	    #group_id, node_weight = gid_weight.setdefault(node_id, (node_id, 1))

	    if group_id != node_id:
	        # found inconsistency, trigger chain update
	        new_group_id, group_weight = find(group_id)
	        gid_weight[node_id] = \
	            (new_group_id, node_weight * group_weight)
	    return gid_weight[node_id]

	def union(dividend, divisor, value):
	    dividend_gid, dividend_weight = find(dividend)
	    divisor_gid, divisor_weight = find(divisor)
	    if dividend_gid != divisor_gid:
	        # merge the two groups together,
	        # by attaching the dividend group to the one of divisor
	        gid_weight[dividend_gid] = \
	            (divisor_gid, divisor_weight * value / dividend_weight)

	# Step 1). build the union groups
	for (dividend, divisor), value in zip(equations, values):
	    union(dividend, divisor, value)

	results = []
	# Step 2). run the evaluation, with "lazy" updates in find() function
	for (dividend, divisor) in queries:
	    if dividend not in gid_weight or divisor not in gid_weight:
	        # case 1). at least one variable did not appear before
	        results.append(-1.0)
	    else:
	        dividend_gid, dividend_weight = find(dividend)
	        divisor_gid, divisor_weight = find(divisor)
	        if dividend_gid != divisor_gid:
	            # case 2). the variables do not belong to the same chain/group
	            results.append(-1.0)
	        else:
	            # case 3). there is a chain/path between the variables
	            results.append(dividend_weight / divisor_weight)
	return results


print(calcEquation([["a","b"],["b","c"]],[2.0,3.0],[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]))
print(calcEquation1([["a","b"],["b","c"]],[2.0,3.0],[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]))

