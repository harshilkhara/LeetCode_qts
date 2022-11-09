def judgeCircle(moves): # TC O(n) SC O(1)
	return (moves.count('L')==moves.count('R') and moves.count('U')==moves.count('D'))

print(judgeCircle("RRDD"))
print(judgeCircle("LRUD"))