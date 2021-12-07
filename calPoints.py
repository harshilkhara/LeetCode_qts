def calPoints(ops): # TC O(n) // SC O(n)
	stack=[]
	for i in ops:
		if i =="+":
			stack.append(stack[-2]+stack[-1])
		elif i =="D":
			stack.append(2*stack[-1])
		elif i =="C":
			stack.pop()
		else:
			stack.append(int(i))
	sum=0
	for j in stack:
		sum+=j
	return sum

print(calPoints(["5","-2","4","C","D","9","+","+"]))

'''
Strat: Let's maintain the value of each valid round on a stack as we process 
the data. A stack is ideal since we only deal with operations involving the 
last or second-last valid round.
'''