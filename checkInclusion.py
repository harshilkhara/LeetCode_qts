# Exactly same as findAnagrams.java & .py
# Approach 1- Sliding window with Arrays
def checkInclusion(s1,s2): # TC O(Ns1+Ns2) // SC O(1)
	ns1,ns2=len(s1),len(s2)
	if ns1>ns2: return False 

	s1Count,s2Count=[0]*26,[0]*26
	for c in s1:
	    s1Count[ord(c)-ord('a')]+=1

	for i in range(ns2):
	    s2Count[ord(s2[i])-ord('a')]+=1 
	    if i>=ns1:
	        s2Count[ord(s2[i-ns1])-ord('a')]-=1
	    if s1Count==s2Count:
	        return True 

	return False

print(checkInclusion("ab","eidbaooo"))