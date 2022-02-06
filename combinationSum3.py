# Approach- Backtracking 

def combinationSum3(k,n): # TC O((9!k)/(9-k)!) // SC O(k)
	results = []
	def backtrack(remain, comb, next_start):
	    if remain == 0 and len(comb) == k:                # goal 
	        # make a copy of current combination
	        # Otherwise the combination would be reverted in other branch of backtracking.
	        results.append(list(comb))
	        return
	    elif remain < 0 or len(comb) == k:
	        # exceed the scope, no need to explore further.
	        return
	    # Iterate through the reduced list of candidates.
	    for i in range(next_start, 9):      
	        comb.append(i+1)
	        backtrack(remain-i-1, comb, i+1)               # choose 
	        # backtrack the current choice 
	        comb.pop()
	backtrack(n, [], 0)
	return results

print(combinationSum3(3,9))

# Same approach but different for-loop and different backtrack pass argument 

def combinationSum31(k,n): # TC O((9!k)/(9-k)!) // SC O(k)
	results = []
	def backtrack(remain, comb, next_start):
	    if remain == 0 and len(comb) == k:
	        # make a copy of current combination
	        # Otherwise the combination would be reverted in other branch of backtracking.
	        results.append(list(comb))
	        return
	    elif remain < 0 or len(comb) == k:
	        # exceed the scope, no need to explore further.
	        return
	    # Iterate through the reduced list of candidates.
	    for i in range(next_start, 10):
	        comb.append(i)
	        backtrack(remain-i, comb, i+1)
	        # backtrack the current choice
	        comb.pop()
	backtrack(n, [], 1)
	return results

print(combinationSum31(3,8))