def binarytodecimal(binary):
	binary=int(binary)
	binary1=binary
	decimal, i ,n= 0, 0, 0
	while binary!=0:
		dec = binary % 10
		decimal = decimal + dec * pow(2, i)
		binary = binary//10
		i += 1
	return decimal   

def decimaltobinary(n):
	binary,ctr,temp = 0,0,int(n)
	while (temp>0):
		binary = ((temp%2)*(10**ctr)) + binary
		temp = int(temp/2)
		ctr += 1
	return binary

def addBinary1(a,b):  
	digitA=binarytodecimal(a)
	digitB=binarytodecimal(b)
	print(digitA)
	print(digitB)
	total=digitA + digitB
	print(total)
	result=decimaltobinary(total)
	return result
	
a=input("Enter first binary string: ")
b=input("Enter second binary string: ")
print(addBinary1(a,b))


def dectobin(n):  #decimal to binary using recursion (tail recursion in printing)
	if n >1:
		dectobin(n//2)
	print(n%2, end="")