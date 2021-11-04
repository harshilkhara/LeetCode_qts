def ispower(x,y):
	if y<=0:
		return False
	elif y==1:
		return True
	else:
		while(y % x==0):
			power=0
			power=power+1
			print(power)
			return (ispower(x,y/x))
		return False

x=int(input("Please enter the base: "))
y=int(input("Please enter the number you want to check: "))
result=ispower(x,y)
print(result)



def power(x,n):
	result1=1
	temp=n
	if x==0:
		return 0
	if n<0:
		temp=temp*(-1)
	for i in range(temp):
		result1*=x
	if n>=1:
		#for i in range (n):
			#result1=x*result1
		return result1
	elif n==0:
		return 1
	else:
		#x=1/x
		#n=n*(-1)
		#for i in range (n):
			#result1= x* result1
		return (1/result1)

x=float(input("Enter the number: "))
n=int(input("Enter the power: "))
result1=power(x,n)
print(result1)


def power1(a,b):
	if b==0:
		return 1 
	else:
		return a*power1(a,b-1)    # for recursion 
           
a=float(input("Enter the number: "))
b=int(input("Enter the power: "))
result2=power1(a,b)
print(result2)

