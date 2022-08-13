def findAndReplacePattern(words,pattern):
	def match(word):
		m1, m2 = {}, {}
		for w, p in zip(word, pattern):
			if w not in m1: m1[w] = p
			if p not in m2: m2[p] = w
			if (m1[w], m2[p]) != (p, w):
				return False
		return True

	filtered=filter(match, words)
	ans=[]
	for i in filtered:
		ans.append(i)
	return ans

def findAndReplacePattern1(words,pattern):
	def match(word):
		P = {}
		for x, y in zip(pattern, word):
		    if P.setdefault(x, y) != y:
		        return False
		return len(set(P.values())) == len(P.values())

	filtered=filter(match, words)
	ans=[]
	for i in filtered:
		ans.append(i)
	return ans


print(findAndReplacePattern(["abc","deq","mee","aqq","dkd","ccc"],"abb"))
print(findAndReplacePattern(["abc","deq","mee","aqq","dkd","ccc"],"abb"))