class Solution:
# Approach 1- Top-down DP (Recursive)
    def numberOfArrays(self, s, k): # TC O(m log k) // SC O(m)
        m, n = len(s), len(str(k))
        mod = 10 ** 9 + 7   
        dp = [0] * (m + 1)
        
        # Number of possible splits for s[start ~ m-1].
        def dfs(start):
            # If we have already updated dp[start], return it.
            if dp[start]:
                return dp[start]
            
            # There is only 1 split for an empty string.
            if start == m:
                return 1
            
            # Number can't have leading zeros.
            if s[start] == '0':
                return 0
            
            # For all possible starting number, add the number of arrays 
            # that can be printed as the remaining string to count.
            count = 0
            for end in range(start, m):
                curr_number = s[start: end + 1]
                if int(curr_number) > k:
                    break
                count += dfs(end + 1)
                
            # Update dp[start] so we don't recalculate it later.
            dp[start] = count % mod
            return count
        
        return dfs(0) % mod

# Approach 2- Bottom-Up DP
    def numberOfArrays1(self, s, k): # TC O(m log k) // SC O(m)
        m, n = len(s), len(str(k))
        mod = 10 ** 9 + 7
        
        # dp[i] records the number of arrays that can be printed as
        # the prefix substring s[0 ~ i - 1]
        dp = [1] + [0] * m
        
        # Iterate over every digit, for each digit s[start]:
        for start in range(m):
            if s[start] == '0':
                continue            
            count = 0
    
            # Iterate over ending digit end and find all valid numbers 
            # s[start ~ end].
            for end in range(start, m):  
                curr_number = s[start:end + 1]
                if int(curr_number) > k:
                    break
                
                # If s[start ~ end] is valid, increment dp[end + 1] by dp[start].
                dp[end + 1] += dp[start]
                dp[end + 1] %= mod
                    
        return dp[-1]

# Approach 3- Bottom-Up DP (Space Optimized)
    def numberOfArrays2(self, s, k): # TC O(m log k) // SC O(log k)
        m, n = len(s), len(str(k))
        mod = 10 ** 9 + 7
        # dp[i % (n + 1)] records the number of arrays that can be printed as
        # the prefix substring s[0 ~ i - 1]
        dp = [1] + [0] * n
        
        # Iterate over every digit, for each digit s[start]:
        for start in range(m):
            if s[start] == '0':
                dp[start % (n + 1)] = 0
                continue
            
            # Iterate over ending digit end and find all valid numbers 
            # s[start ~ end].
            for end in range(start, m):
                if int(s[start : end + 1]) > k:
                    break

                # If s[start ~ end] is valid, increment dp[(end + 1) % (n + 1)] by dp[start].
                dp[(end + 1) % (n + 1)] += dp[start % (n + 1)]
                dp[(end + 1) % (n + 1)] %= mod
            
            # Set dp[start % (n + 1)] as 0.
            dp[start % (n + 1)] = 0

        return dp[m % (n + 1)]


s=Solution()
print(s.numberOfArrays("1317",2000))
print(s.numberOfArrays1("1317",2000))
print(s.numberOfArrays2("1317",2000))
