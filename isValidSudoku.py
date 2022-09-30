def isValidSudoku(board):
	n=9

	rows=[set() for _ in range(n)]
	cols=[set() for _ in range(n)]
	boxes=[set() for _ in range(n)]

	for r in range(n):
		for c in range(n):
			val=board[r][c]
			if val=='.':
				continue

			if val in rows[r]:
				return False 

			rows[r].add(val)

			if val in cols[c]:
				return False 

			cols[c].add(val)

			idx=(r//3)*3+(c//3)
			if val in boxes[idx]:
				return False

			boxes[idx].add(val)

	return True 

print(isValidSudoku([["5","3",".",".","7",".",".",".","."],
	["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],
	["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],
	["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],
	[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]))

