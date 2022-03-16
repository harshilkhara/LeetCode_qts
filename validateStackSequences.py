'''
Approach 1- Greedy

We have to push the items in order, so when do we pop them?

If the stack has say, 2 at the top, then if we have to pop that value next, we must do it now. 
That's because any subsequent push will make the top of the stack different from 2, and we will 
never be able to pop again.

Algorithm

For each value, push it to the stack.

Then, greedily pop values from the stack if they are the next values to pop.

At the end, we check if we have popped all the values successfully.

'''
def validateStackSequences(pushed,popped): # TC O(N) N--> length of pushed & popped // SC O(N)
	j=0
	stack=[]
	for i in pushed:
		stack.append(i)
		while stack and j < len(popped) and stack[-1] == popped[j]:
			stack.pop()
			j+=1
	return j==len(popped)
	#return not stack        // even this works 

print(validateStackSequences([1,2,3,4,5],[4,5,3,2,1]))
print(validateStackSequences([1,2,3,4,5],[4,3,5,1,2]))