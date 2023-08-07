class Solution:
# Approach 1- Backtrack
    def combine(self, n, k):
        def backtrack(start, path):
            if len(path)==k:
                ans.append(list(path))
                return

            need = k - len(path)
            remain = n - start + 1
            available = remain - need 
            
            for i in range(start, n+1):
                path.append(i)
                backtrack(i+1, path)
                path.pop()
        

        ans=[]
        backtrack(1,[])
        return ans

s=Solution()
print(s.combine(4,2))