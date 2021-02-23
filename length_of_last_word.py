def lengthOfLastWord(s):
	n=s.split()
	if len(n)==0:
		return 0
	else:
		return len(n[-1])
               
s=input("Enter the string: ")
x=lengthOfLastWord(s)
print(x)

