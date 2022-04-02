# Approach 1- Two pointers 
def reverseString(s): # TC O(n) // SC O(1)
	l,r=0,len(s)-1
	while l < r:
		s[l],s[r]=s[r],s[l]
		l+=1
		r-=1
	return s 

print(reverseString(["h","e","l","l","o"]))


