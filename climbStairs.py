def climbStairs(n):
	one,two= 1, 1
	for i in range(n-1):
		temp=one
		one=one + two 
		two=temp
	return one 

n=int(input("Enter the number of steps:"))
result=climbStairs(n)
print(result,"is the number of ways you can climb",n, "stairs")