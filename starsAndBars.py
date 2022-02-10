'''
s="|**|*|*"
startIndex=[1,1]          
EndIndex= [5,6]
starCount=(EndIndexBar-startIndexBar+1)-barsCount --> This is the main idea 
'''
def starsAndBars(s, startIndex, EndIndex): #TC O(n) // SC O(1)
	s1=s[startIndex[0]-1:EndIndex[0]]
	s2=s[startIndex[1]-1:EndIndex[1]]
	#print(s1)
	#print(s2)
	def start_end_bar(s):
		bar_index=[]
		for i,c in enumerate(s):
			if c=="|":
				bar_index.append(i+1)
		bar_counter=len(bar_index)
		if len(bar_index)>=2:
			return [bar_index[0],bar_index[-1]],bar_counter
		elif len(bar_index)<2:
			return 0

	def count_stars(bar_index):
		count=0
		count=(bar_index[0][-1]-bar_index[0][0]+1)-bar_index[1]
		return count
	x=start_end_bar(s1)
	#print(x)
	y=start_end_bar(s2)
	#print(y)
	a=count_stars(x) 
	#print(a)
	b=count_stars(y) 
	#print(b)
	return [a,b]

print(starsAndBars("|**|*|*|*|***|***|",[1,5],[8,17]))
print(starsAndBars("|**|*|*",[1,1],[5,6]))

