def maxWealth(accounts): # TC O(M*N) // SC O(1)
	maxWealth=0
	for account in accounts:
		wealth=sum(account)
		maxWealth=max(maxWealth,wealth)
	return wealth

def maxWealth1(accounts): # TC O(M*N) // SC O(M)
	maxWealth=[sum(account) for account in accounts]
	res=max(maxWealth)
	return res 

print(maxWealth([[1,2,3],[3,2,1]]))
print(maxWealth1([[1,2,5],[3,2,1]]))
