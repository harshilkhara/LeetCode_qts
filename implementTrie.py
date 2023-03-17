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


	def prefixSearch(self, word):
		node=self.root 
		for c in word:
			if c in node.children:
				node=node.children[c]
			else:
				return None 

		return node 

	def search(self, word):
		node=self.root 
		node=self.prefixSearch(word)
		return node and node.isWord 

	def startsWith(self, prefix):
		node=self.root 
		node=self.prefixSearch(prefix)
		return node!=None


obj=Trie()
obj.insert("apple")
print(obj.search("apple"))
print(obj.search("app"))
print(obj.startsWith("app"))
obj.insert("app")
print(obj.search("app"))
