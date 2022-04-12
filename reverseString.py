# Approach 1- Two pointers 
def reverseString(s): # TC O(n) // SC O(1)
	l,r=0,len(s)-1
	while l < r:
		s[l],s[r]=s[r],s[l]
		l+=1
		r-=1
	return s 

def reverseString1(s): # TC O(n) // SC O(n)
	n=len(s)
	result=[]
	for i in range(n-1,-1,-1):
		result.append(s[i])
	return result

print(reverseString(["h","e","l","l","o"]))
print(reverseString1(["h","e","l","l","o"]))


