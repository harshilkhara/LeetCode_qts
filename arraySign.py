class Solution():
# Approach 1- Counting the negative numbers
    def arraySign(self, nums): # TC O(n) // SC O(1)
        countNegativeNumbers = 0
        for num in nums:
            if num == 0:
                return 0
            if num < 0:
                countNegativeNumbers = countNegativeNumbers + 1

        if countNegativeNumbers %2 == 0:
            return 1
        return -1

# Approach 2- Flipping the sign
    def arraySign1(self, nums): # TC O(n) // SC O(1)
        sign = 1
        for num in nums:
            if num == 0:
                return 0
            if num < 0:
                sign = -1 * sign

        return sign


s=Solution()
print(s.arraySign([-1,-2,-3,-4,3,2,1]))
print(s.arraySign1([-1,-2,-3,-4,3,2,1]))