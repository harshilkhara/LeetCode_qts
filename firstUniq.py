def firstUniqChar(s):
	hash={}
	for i in s:                  #creating hash map with frequency
		if i in hash:
			hash[i]+=1
		else:
			hash[i]=1

	for idx, char in enumerate(s):   #returning first non-repeating unique character
		if hash[char]==1:
			return idx
	return -1

import collections                    #With imported library collections 
def firstUniqChar1(s):
	counter=collections.Counter(s)
	for idx,char in enumerate(s):
		if counter[char]==1:
			return idx
	return -1

print(firstUniqChar("leetcode"))
print(firstUniqChar1("loveleetcode"))



	

