# Approach 1- Two for loops 
def lengthOfLastWord(s): # TC O(n) // SC O(1)
	# trim the trailing spaces
	p = len(s) - 1
	while p >= 0 and s[p] == ' ':
	    p -= 1

	# compute the length of last word
	length = 0
	while p >= 0 and s[p] != ' ':
	    p -= 1
	    length += 1
	return length

# Approach 2- One for loop
def lengthOfLastWord1(s): # TC O(n) // SC O(1)
	p=len(s)
	length=0
	while p>0:
		p-=1
		if s[p]!=' ':
			length+=1
		elif length>0:
			return length 
	return length 


#Approach 3- Built-in functions
def lengthOfLastWord2(s): # TC O(n) // SC O(n)
	n=s.split()
	if len(n)==0:
		return 0
	else:
		return len(n[-1])
               
print(lengthOfLastWord("Hello World"))
print(lengthOfLastWord1("Hello World"))
print(lengthOfLastWord2("Hello World"))

