def detectCapitalUse(word): # TC O(n) // SC O(1)
	n = len(word)

	match1, match2, match3 = True, True, True

	# case 1: All capital
	for i in range(n):
	    if not word[i].isupper():
	        match1 = False
	        break
	if match1:
	    return True

	# case 2: All not capital
	for i in range(n):
	    if word[i].isupper():
	        match2 = False
	        break
	if match2:
	    return True

	# case 3: All not capital except first
	if not word[0].isupper():
	    match3 = False
	if match3:
	    for i in range(1, n):
	        if word[i].isupper():
	            match3 = False
	if match3:
	    return True

	# if not matching
	return False

def detectCapitalUse1(word):   # TC O(n) // SC O(1)
	n=len(word)
	if n==1:
		return True 

	# case 1: All capital
	if word[0].isupper() and word[1].isupper():
		for i in range(2,n):
			if not word[i].isupper():
				return False

	# case 2 and case 3
	else:
		for i in range(1,n):
			if word[i].isupper():
				return False

	# if pass one of the cases
	return True 

import re
def detectCapitalUse2(word): # TC O(n) but depends on implementaion // SC O(1)
	return re.fullmatch(r"[A-Z]*|.[a-z]*", word)
	'''
	another method-- return word in (
        word.upper(),
        word.lower(),
        word.capitalize(),
    )
    another method   return word.islower() or word.isupper() or word.istitle()
    '''
print(detectCapitalUse("Leetcode"))
print(detectCapitalUse1("leetcode"))
print(detectCapitalUse2("Leetcode"))

