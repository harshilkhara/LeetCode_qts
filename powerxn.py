def helper(x,n):     # TC O(log n)   // SC O(1)
	if x==0:
		return 0
	if n==0:
		return 1
	res=helper(x,n//2)   # dividing n into half. Therefore, O(log n)
	res=res*res
	if n % 2 !=0:
		return x*res
	else:
		return res

def newpower(x,n):
	res=helper(x, abs(n))
	if n>=0:
		return res
	else:
		return 1/res


x=float(input("Enter the number: "))
n=int(input("Enter the power: "))
result=newpower(x,n)
print(result)
