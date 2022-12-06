# Approach 1- Sort and divide 
# Very similar to twoSum when input is sorted 
def dividePlayers(skill): # TC O(n log n) // SC O(n)
	skill.sort()
	l,r=0,len(skill)-1
	res=0
	skills=skill[0]+skill[len(skill)-1]
	while l<r:
		totalSkill=skill[l]+skill[r]
		if totalSkill!=skills:
			return -1 
		res+=skill[l]*skill[r]
		l+=1
		r-=1
	return res 

print(dividePlayers([3,2,5,1,3,4]))


