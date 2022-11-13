# Approac 1- Swapping first and last..
# Similar logic to reverse string 
def reverseWordsI(s): # TC O(n) SC O(n)
	s=s.split()
	l,r=0,len(s)-1
	while(l<r):
		s[l],s[r]=s[r],s[l]
		l+=1
		r-=1 

	return " ".join(s)

def reverseWordsI1(s): # TC O(n) SC O(n)
	s=s.split()
	res=""
	for i in range(len(s)-1,-1,-1):
		res+=s[i]
		if i!=0:
			res+=" "
	return res 

# Approach 2- Built in function of reverse 

def reverseWordsI2(s): # TC O(n) SC (n)
	return " ".join(reversed(s.split()))

print(reverseWordsI("the sky is blue"))
print(reverseWordsI1("the sky is blue"))
print(reverseWordsI2("the sky is blue"))