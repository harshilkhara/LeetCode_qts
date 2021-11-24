def addDigits(num): #Itereative method O(n)
	sum=0
	while num:
		sum+=num%10
		num//=10
		if sum>9 and num==0:
			num=sum
			sum=0
	return sum

def addDigits2(num):
	while num > 9:
		sum=0
		while num:
			sum+=num%10
			num//=10
		num=sum
	return num

def addDigits1(num):      #Fastest way TC O(1) SC O(1)
	#return num%9 or 9 if num else 0
	if num:
		return num%9 or 9
	else:
		return 0

num=int(input("Enter the number: "))
print(addDigits(num))
print(addDigits1(num))
print(addDigits2(num))

