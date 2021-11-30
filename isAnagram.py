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

def isAnagram1(s,t):  # TC O(nlogn)  // SC O(1)
	if len(s)!=len(t):
		return False
	a=sorted(s)
	b=sorted(t)
	if a==b:
		return True
	return False


print(isAnagram("anagram","nagaram"))
print(isAnagram("car","rat"))