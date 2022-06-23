#Approach 1- Simulation 
def ransomeNote(ransomeNote,magazine): # TC O(M*N) // SC O(M)
	for c in ransomeNote:
		if c not in magazine:
			return False 
		index=magazine.index(c) 
		magazine= magazine[0:index] + magazine[index+1:] 
	return True 

#Approach 2- Two Hashmaps 
import collections
def ransomeNote1(ransomeNote,magazine): # TC O(M) // SC O(M) --> O(1)

	ransomeMap=collections.Counter(ransomeNote)
	magazineMap=collections.Counter(magazine)

	if len(ransomeNote)> len(magazine): 
		return False 

	for c in ransomeNote:
		if ransomeMap[c] > magazineMap[c]:
			return False
	return True 

#Approach 3 - One Hashmap   
def ransomeNote2(ransomeNote,magazine): # TC O(N) // SC O(M)
	magazineMap=collections.Counter(magazine)

	if len(ransomeNote)> len(magazine): return False

	for c in ransomeNote:
		if magazineMap[c]<=0:
			return False 
		magazineMap[c]-=1
	
	return True 

print(ransomeNote("aab","acbba"))
print(ransomeNote1("acda","acdb"))
print(ransomeNote2("acda","acdbaa"))


