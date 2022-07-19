def isPalindrome(s): # TC O(N) // SC O(1)
	i,j=0,len(s)-1
	while i < j:
		while i < j and not s[i].isalnum():
			i+=1
		while i < j and not s[j].isalnum():
			j-=1 

		if s[i].lower()!=s[j].lower():
			return False
		i+=1
		j-=1 
	return True 

def isPalindrome1(s):
	filtered_chars = filter(lambda ch: ch.isalnum(), s)
	lowercase_filtered_chars = map(lambda ch: ch.lower(), filtered_chars)

	filtered_chars_list = list(lowercase_filtered_chars)
	reversed_chars_list = filtered_chars_list[::-1]

	return filtered_chars_list == reversed_chars_list

print(isPalindrome("A man, a plan, a canal: Panama"))
print(isPalindrome1("A man, a plan, a canal: Panama"))