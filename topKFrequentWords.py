from collections import Counter
from heapq import heappush, heappop
#Approach 1- Brute Force 
def topKFrequentWords(words,k): # TC O(n log n) // SC O(n)
	cnt = Counter(words)
	return sorted(list(cnt.keys()), key=lambda x: (-cnt[x], x))[:k]


#Approac 3- Min Heap  # TC O(n log k) // SC O(n)
class Pair:
	def __init__(self,word,freq):
		self.word=word 
		self.freq=freq  

	def __lt__(self,p):
		return self.freq < p.freq or (self.freq == p.freq and self.word > p.word)

def topKFrequentWords1(words,k):
	cnt = Counter(words)
	h = []
	for word, freq in cnt.items():
	    heappush(h, Pair(word, freq))
	    if len(h) > k:
	        heappop(h)
	return [p.word for p in sorted(h, reverse=True)]


print(topKFrequentWords(["i","love","leetcode","i","love","coding"],2))
print(topKFrequentWords1(["i","love","leetcode","i","love","coding"],2))