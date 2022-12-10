def isPowerOfFour(n):
	if n==0:
		return False 
	while n%4==0:
		n/=4

	return n==1

def isPowerOfFour1(n):
	nums=[]
	def powers():
		n=15
		lastNum=1
		nums.append(1)
		for i in range(n+1):
			lastNum*=4
			nums.append(lastNum)

	powers()
	return n in nums

print(isPowerOfFour(12))
print(isPowerOfFour1(16))


