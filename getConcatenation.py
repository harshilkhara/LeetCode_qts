class Solution:
    def getConcatenation(self, nums): # TC O(n) // SC O(1)
        answer=nums[:]
        for num in nums:
            answer.append(num)
        
        return answer

    def getConcatenation1(self, nums): # TC O(n) // SC O(1)
        return nums*2 

s=Solution()
print(s.getConcatenation([1,2,1]))
print(s.getConcatenation1([1,2,1]))
