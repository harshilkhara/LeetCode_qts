class UnionFind:
	def __init__(self, n, parent=None, size=None):
		self.parent=[i for i in range(n)]
		self.size=[1]*n

	def find(self, vertex):
		if self.parent[vertex]!=vertex:
			self.parent[vertex]=self.find(self.parent[vertex])

		return self.parent[vertex]
	
	def union(self, v1, v2):
		v1=self.find(v1)
		v2=self.find(v2)

		if v1!=v2:
			if self.size[v1]>self.size[v2]:
				self.parent[v2]=v1
				self.size[v1]+=self.size[v2]
			else:
				self.parent[v1]=v2
				self.size[v2]+=self.size[v1]
		return   

#un=UnionFind(2)
