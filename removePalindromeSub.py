def removePalindromeSub(s): # TC O(N) // SC O(N)
	if not s:
	    return 0
	if s == s[::-1]:
	    return 1
	return 2

def removePalindromeSub1(s): # TC O(N) // SC O(1)
	def check_palindrome(s):
		left,right=0,len(s)-1 
		while left<right:
			if s[left]!=s[right]:
				return False
			left+=1
			right-=1
		return True 

	if not s:
		return 0 
	if check_palindrome(s):
		return 1 
	return 2

print(removePalindromeSub("ababa"))
print(removePalindromeSub1("abbabab"))