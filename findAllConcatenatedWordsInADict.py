# Very similar to wordBreak.java and .py DP logic 
# Approach 1- DP 
def findAllConcatenatedWordsInADict(words): # TC O(M^3. N) // SC O(M.N)
	wordSet=set(words)
	ans=[]
	for word in words:
		length=len(word)
		dp=[False]*(length+1)
		dp[0]=True 
		for i in range(1,length+1):
			for j in range(1 if i==length else 0, i):
				if not dp[i]:
					dp[i]=dp[j] and word[j:i] in wordSet
		if dp[length]:
			ans.append(word)
	return ans 

print(findAllConcatenatedWordsInADict(["cat","cats","catsdogcats","dog","dogcatsdog",
	"hippopotamuses","rat","ratcatdogcat"]))
