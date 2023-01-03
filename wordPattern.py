# Approach 1- Two HashMaps
def wordPattern(pattern,s): # TC O(n) // SC O(m) 
	charmap,wordmap={},{}
	words=s.split(' ')

	if len(words)!=len(pattern):
		return False 

	#for i in range(len(words)):
		#c=pattern[i]
		#w=words[i]
	for c,w in zip(pattern,words):
		if c not in charmap:
			if w in wordmap:
				return False 
			else:
				charmap[c]=w 
				wordmap[w]=c 
		else:
			if charmap[c]!=w:
				return False 

	return True 

# Approach 2- One index HashMap
def wordPattern1(pattern,s): # TC O(n) // SC O(m) 
	map_index = {}
	words = s.split()

	if len(pattern) != len(words):
	    return False

	for i in range(len(words)):
	    c = pattern[i]
	    w = words[i]

	    char_key = 'char_{}'.format(c)
	    char_word = 'word_{}'.format(w)
	    
	    if char_key not in map_index:
	        map_index[char_key] = i
	    
	    if char_word not in map_index:
	        map_index[char_word] = i 
	    
	    if map_index[char_key] != map_index[char_word]:
	        return False

	return True

print(wordPattern("abba","dog cat cat dog"))
print(wordPattern1("abba","dog cat cat dog"))
