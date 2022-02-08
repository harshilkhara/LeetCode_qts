#Approach- Backtracking
def partition(s):  # TC O(n 2^n) // SC O(n)
	res=[]
	part=[]

	def backtrack(i):
		if i >=len(s):                # goal
			res.append(part.copy())
			return 
		for j in range(i,len(s)):
			if isPali(s,i,j):         # constraint
				part.append(s[i:j+1])
				backtrack(j+1)        # choose
				part.pop()            # backtrack
	backtrack(0)
	return res 

def isPali(s,l,r):
	while l < r:
		if s[l]!=s[r]:
			return False
		l,r=l+1,r-1 
	return True 

#Approach- Backtracking with Dynamic Programming 

def partition1(s): # TC O(n 2^n) // SC O(n.n)
	res=[]
	part=[]
	dp=[[False for i in range(len(s))]for j in range(len(s))] #TC O(n^2) // SC O(n.n)
	def backtrack(i):
		if i>=len(s):
			res.append(part.copy())
			return 
		for j in range(i,len(s)):
			if s[i]==s[j] and (j-i<=2 or dp[i+1][j-1]):
				dp[i][j]=True
				part.append(s[i:j+1])
				backtrack(j+1)
				part.pop()
	backtrack(0)
	return res 

print(partition("aab"))
print(partition1("aab"))