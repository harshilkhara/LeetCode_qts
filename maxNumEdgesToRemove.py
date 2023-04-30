class UnionFind:
    def __init__(self, n):
        self.parent=[i for i in range(n+1)]
        self.size=[1]*(n+1)
        self.components=n
    
    def find(self, vertex):
        if self.parent[vertex]!=vertex:
            self.parent[vertex]=self.find(self.parent[vertex])

        return self.parent[vertex]


    def union(self, v1 ,v2):
        v1=self.find(v1)
        v2=self.find(v2)
        
        if v1==v2: return 0
        
        if v1!=v2:
            if self.size[v1]>self.size[v2]:
                self.parent[v2]=v1
                self.size[v1]+=self.size[v2]
            else:
                self.parent[v2]=v1
                self.size[v2]+=self.size[v1]
        
        self.components-=1
        return 1
    
    def isConnected(self):
        return self.components==1
                
class Solution:

# Approach 1- DSU
    def maxNumEdgesToRemove(self, n, edges): # TC O(e+v) // SC O(n)
        Alice=UnionFind(n)
        Bob=UnionFind(n)
        
        edgesRequired=0
        for edge in edges:
            if edge[0]==3:
                edgesRequired+=(Alice.union(edge[1], edge[2]) | Bob.union(edge[1], edge[2]))
        
        for edge in edges:
            if edge[0]==1:
                edgesRequired+=Alice.union(edge[1], edge[2])
            elif edge[0]==2:
                edgesRequired+=Bob.union(edge[1], edge[2])
        
        if Alice.isConnected() and Bob.isConnected():
            return len(edges)-edgesRequired
        
        return -1

s=Solution()
print(s.maxNumEdgesToRemove(4,[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]))
