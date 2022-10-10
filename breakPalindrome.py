#Approach 1- exactly like .toCharArray()
def breakPalindrome(palindrome):
	s=list(palindrome)
	if len(palindrome)==1: return ""
	for i in range(len(palindrome)//2):
	    if s[i]!='a':
	        s[i]='a'
	        return "".join(s)

	s[len(palindrome)-1]='b'
	return "".join(s)

#Approach 2- slicing 
def breakPalindrome1(palindrome):
	if len(palindrome) == 1:
            return ""
	for i in range(len(palindrome) // 2):
	    if palindrome[i] != 'a':
	        return palindrome[:i] + 'a' + palindrome[i+1:]

	return palindrome[:-1] + 'b'

print(breakPalindrome("abba"))
print(breakPalindrome1("aaaa"))