def combinationSum(candidates,target): # TC O(N^(T/M+1)) // SC O(T/M)
	results = []

	def backtrack(remain, comb, start):
	    if remain == 0:                                      # goal
	        # make a deep copy of the current combination
	        results.append(list(comb))
	        return
	    elif remain < 0:
	        # exceed the scope, stop exploration.
	        return
	    for i in range(start, len(candidates)):
	        # add the number into the combination
	        comb.append(candidates[i])                          
	        # give the current number another chance, rather than moving on
	        backtrack(remain - candidates[i], comb, i)                  # choose
	        # backtrack, remove the number from the combination
	        comb.pop()
	backtrack(target, [], 0)
	return results

print(combinationSum([2,3,6,7],7))