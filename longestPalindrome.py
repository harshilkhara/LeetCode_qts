# Approach- Expand around the centre is used 

def longestPalindrome(s): # TC O(n^2)  // SC O(1)
	res="" 
	resLen=0
	for i in range(len(s)):
		#odd length 
		l,r=i,i
		while l >=0 and r < len(s) and s[l]==s[r]:
			if (r-l+1)>resLen:
				res=s[l:r+1]
				resLen=r-l+1
			l-=1
			r+=1
		#even length 
		l,r=i,i+1
		while l>=0 and r < len(s) and s[l]==s[r]:
			if (r-l+1)>resLen:
				res=s[l:r+1]
				resLen=r-l+1
			l-=1
			r+=1

	return res 

def longestPalindrome(s): # TC O(n^2)  // SC O(1)
	res="" 
	resLen=0
	for i in range(len(s)):
		#odd length 
		l,r=i,i
		while l >=0 and r < len(s) and s[l]==s[r]:
			if (r-l+1)>resLen:
				res=s[l:r+1]
				resLen=r-l+1
			l-=1
			r+=1
		#even length 
		l,r=i,i+1
		while l>=0 and r < len(s) and s[l]==s[r]:
			if (r-l+1)>resLen:
				res=s[l:r+1]
				resLen=r-l+1
			l-=1
			r+=1

	return res 

print(longestPalindrome("babad"))
