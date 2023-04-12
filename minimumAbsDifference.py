class Solution:
# Approach 1- Sorting 
    def minimumAbsDifference(self, arr): # TC O(n log n) // SC O(n)
        arr.sort()
        answer=[]
        minDiff=float('inf')
        for i in range(1,len(arr)):
            diff=arr[i]-arr[i-1]
            if minDiff==diff:
                answer.append([arr[i-1],arr[i]])
            elif diff<minDiff:
                answer.clear()
                minDiff=diff
                answer.append([arr[i-1],arr[i]]) 
        
        return answer

s=Solution()
print(s.minimumAbsDifference([4,2,1,3]))