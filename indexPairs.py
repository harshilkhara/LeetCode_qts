class TrieNode:
	def __init__(self):
		self.children={}
		self.isWord=False 

class Trie:
	def __init__(self):
		self.root=TrieNode()


	def insert(self, word):
		node=self.root
		for c in word:
			if c not in node.children:
				node.children[c]=TrieNode()
			node=node.children[c]

		node.isWord=True

class Solution:
# Approach 1- Brute Force 
	def indexPairs(self, text, words): # TC O(n.s + m^3) // SC O(n.s)
		words = set(words)
		ans = []
		for i in range(len(text)): # TC O(n)
		    for j in range(i, len(text)): # TC O(n)
		        if text[i:j + 1] in words: # TC O(n)
		            ans.append([i, j])
		return ans


	def indexPairs1(self, text, words): # TC O(n.s + m^2) // SC O(n.s)
		trie=Trie()
		for word in words:
			trie.insert(word)

		answer=[]
		for i in range(len(text)): # TC O(n)
			p=trie.root
			for j in range(i, len(text)): # TC O(n)
				if text[j] not in p.children:
					break 
				p=p.children[text[j]]
				if p.isWord:
					answer.append([i, j])

		return answer

s=Solution()
print(s.indexPairs("thestoryofleetcodeandme", ["story","fleet","leetcode"]))
print(s.indexPairs1("thestoryofleetcodeandme", ["story","fleet","leetcode"]))






