# Approach- Categorize by Count 
def isAnagram(s,t):    # TC O(N)  // SC O(N)
	if len(s)!=len(t):
		return False

	hash,hash1={},{}
	for i in s:
		if i in hash:
			hash[i]+=1
		else:
			hash[i]=1

	for j in t:
		if j in hash1:
			hash1[j]+=1
		else:
			hash1[j]=1

	if hash==hash1:
		return True
	return False

# Approach- Categorized by sorted strings 
def isAnagram1(s,t):  # TC O(nlogn)  // SC O(1)
	if len(s)!=len(t):
		return False
	a=sorted(s)
	b=sorted(t)
	if a==b:
		return True
	return False

import collections
def isAnagram2(s,t):
	if len(s)!=len(t): 
		return False
	
	sCounter=collections.Counter(s) # The ransome note approach
	for c in t:
	    if sCounter[c]<=0:
	        return False
	    sCounter[c]-=1
	return True

print(isAnagram("anagram","nagaram"))
print(isAnagram1("car","rat"))
print(isAnagram2("car","acr"))