#Approach 1- Recursion 
def fib(n):  #TC O(2^n) SC O(n)
	if n<=1:
		return n 

	return fib(n-1)+fib(n-2)

# Approach 2- Climbing stairs like (Iterative Bottom Up DP)
def fib1(n): # TC O(N) // SC O(1)
	if n<=1:
		return n 
	one=1
	two=0 
	for i in range(2,n+1):
		temp=one 
		one+=two 
		two=temp 
	return one

# Approach 3- Bottom Up DP 
def fib2(n): # TC O(N) // SC O(N)
	if n<=1:
		return n 

	cache=[0]*(n+1)
	cache[1]=1 
	for i in range(2,n+1):
		cache[i]=cache[i-1]+cache[i-2]

	return cache[n]

# Approach 4- Top Down DP
def fib3(n): # TC O(N) // SC O(N)
	cache={0:0,1:1}
	if n in cache:
		return cache[n]

	cache[n]=fib(n-1)+fib(n-2)
	return cache[n]

print(fib(7))
print(fib1(11))
print(fib2(11))
print(fib3(11))