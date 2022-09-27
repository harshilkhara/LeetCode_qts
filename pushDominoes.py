# Approach 1- Calculating Forces 
def pushDominoes(dominos): # TC O(n) // SC O(n)
	n=len(dominoes)
	forces=[0]*n
	force=0
	for i in range(n):
	    if dominoes[i]=='R':
	        force=n
	    elif dominoes[i]=='L':
	        force=0
	    else:
	        force=max(force-1,0)
	        
	    forces[i]+=force 

	force=0
	for i in range(n-1,-1,-1):
	    if dominoes[i]=='L':
	        force=n
	    elif dominoes[i]=='R':
	        force=0
	    else:
	        force=max(force-1,0)
	        
	    forces[i]-=force 

	ans=""
	for force in forces:
	    if force >0 :
	        ans+='R'
	    elif force < 0:
	        ans+='L'
	    else:
	        ans+='.'

	#return "".join('.' if f==0 else 'R' if f>0 else 'L' for f in forces)
	return ans