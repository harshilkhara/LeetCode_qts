import bisect
class Solution:
# Approach 1- Greedy + Binary Search
    def longestObstacle(self, obstacles): # TC O(n log n) SC O(n)
        n=len(obstacles)
        answer=[1]*n
        lis=[]
        lisLength=0
        for i in range(len(obstacles)):
            height=obstacles[i]
            idx=bisect.bisect_right(lis, height)
            if idx==len(lis):
                lis.append(height)
            else:
                lis[idx]=height
            answer[i]=1+idx
        
        return answer


s=Solution()
print(s.longestObstacle([1,2,3,2]))
