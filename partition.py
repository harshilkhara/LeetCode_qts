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

print(partition("aab"))