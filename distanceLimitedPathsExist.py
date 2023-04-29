class Solution:
# Approach 1- DSU
    def distanceLimitedPathsExist(self, n, edgeList, queries): # TC O(n + e log e + q log q) //
        # SC O(n+q)
        def find(vertex, parent):
            if parent[vertex]!=vertex:
                parent[vertex]=find(parent[vertex], parent)

            return parent[vertex]
            

        def union(v1 ,v2, parent, size):
            v1=find(v1, parent)
            v2=find(v2, parent)

            if v1!=v2:
                if size[v1]>size[v2]:
                    parent[v2]=v1
                    size[v1]+=size[v2]
                else:
                    parent[v2]=v1
                    size[v2]+=size[v1]
        
        parent=[i for i in range(n)]
        size=[1]*n
        
        queriesCount=len(queries)
        answer=[False]*queriesCount
        queriesWithIndex=[[] for _ in range(queriesCount)]
        
        for i in range(queriesCount):
            queriesWithIndex[i]=queries[i]
            queriesWithIndex[i].append(i)
        
        
        edgeList.sort(key=lambda x:x[2])
        
        queriesWithIndex.sort(key=lambda x:x[2])
        
        edgeIndex=0
        for [p, q, limit, index] in queriesWithIndex:
            
            while edgeIndex<len(edgeList) and edgeList[edgeIndex][2]<limit:
                v1=edgeList[edgeIndex][0]
                v2=edgeList[edgeIndex][1]
                
                union(v1, v2, parent, size)
                edgeIndex+=1
            
            answer[index]=find(p, parent)==find(q, parent)
        
        return answer

s=Solution()
print(s.distanceLimitedPathsExist(3,[[0,1,2],[1,2,4],[2,0,8],[1,0,16]],[[0,1,2],[0,2,5]]))
