def lexicographicalMaxSubstring(s):
	print(list(s)) # basically s.toCharArray()
	print(max(list(s)))  # max of those s.toCharArray()
	mxInd=s.index(max(list(s))) # index of the max of s.toCharArray()
	return s[mxInd:]

print(lexicographicalMaxSubstring("baca"))