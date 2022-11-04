# very similar to reverse string.java 
# Approach 1- Two Pointers
def reverseVowels(s): # TC O(n) // SC O(N)
	vowels=['A','a','E','e','I','i','O','o','U','u']
	seen=set(vowels)
	l,r=0,len(s)-1
	s=list(s)
	while l<r:
		while l<=len(s)-1 and s[l] not in seen:
			l+=1
		while r>=0 and s[r] not in seen:
			r-=1
		if (l<r):
			temp=s[l]
			s[l]=s[r]
			s[r]=temp
			l+=1
			r-=1

	return "".join(s)

print(reverseVowels("hello")) 
print(reverseVowels("leetcode")) 
