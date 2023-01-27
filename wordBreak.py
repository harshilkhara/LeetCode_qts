from collections import deque
def wordBreak(s,wordDict): # TC O(n^3) // SC O(n)
	wordDictSet=set(wordDict)
	q=deque()
	q.append(0)
	visited=[False]*len(s)
	while q:
		start=q.popleft()
		if visited[start]:
			continue 
		for end in range(start+1,len(s)+1):
			if s[start:end] in wordDictSet:
				q.append(end)
				if end==len(s):
					return True
		visited[start]=True 
	
	return False 

def wordBreak1(s,wordDict): # TC O(n^3) // SC O(n)
	wordDictSet=set(wordDict)
	dp=[False]*(len(s)+1)
	dp[0]=True 
	for i in range(1,len(s)+1):
		for j in range(i):
			if dp[j] and s[j:i] in wordDictSet:
				dp[i]=True 
				break 

	return dp[len(s)]


print(wordBreak("leetcode",["leet","code"]))
print(wordBreak1("leetcode",["leet","code"]))


