class Solution:
# Approach 1- Backtracking
    def maximumRequests(self, n, requests): # TC O(2^m * n) // SC O(m+n)
        
        def backtrack(index, count):
            nonlocal answer
            
            if index==len(requests):
                for val in indegree:
                    if val!=0:
                        return
                answer=max(answer, count)
                return
            
            indegree[requests[index][0]]-=1
            indegree[requests[index][1]]+=1
            
            backtrack(index+1, count+1)
            
            
            indegree[requests[index][0]]+=1
            indegree[requests[index][1]]-=1
            
            backtrack(index+1, count)
    
        
        indegree=[0]*n
        answer=0
        backtrack(0, 0)
        
        return answer

s=Solution()
print(s.maximumRequests(3, [[0,0],[1,2],[2,1]]))

