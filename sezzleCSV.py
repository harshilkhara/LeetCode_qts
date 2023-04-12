'''
You are given a table containing data. The first row contains the column headers; all the other rows contain the data. Some of the rows are defective. A row is defective if it contains at least one cell with a NULL value written in it. You are supposed to delete all of the defective rows.
In the sample below, the second row is defective. It contains a NULL in the age column. The first row (the header) is never defective. Every cell contains a single word. Each word may contain only digits (0° - '97. lowercase and uppercase English letters (a'- 'z', A - Z): for example:
cheese:essesses
id name age score

1
Jack NULL
12
| 17 Betty
28 1
11
For instance, in the example above, after removing the defective row the table should look like this:
id name age | score
17 Betty 28
11
You cannot change the order of rows. The number of rows and columns may differ in different test cases. The case of the letters matters (a' # 'A).
The table is given in CSV (comma-separated values) format. Every two consecutive cells in each row are separated by a single comma " symbol. Every two consecutive rows are separated by a new-line "In' symbol. For example, the first table from the task statement, written in CSV format, is the single string: *id,name,age,scorein 1 Jack, NULL, 12\n 17, Betty,28, 11°.
You may assume that each row has the same number of cells.
Write a function:
class solution ( pubile String solution (string S): )
which, given a string S of length N, returns the table without the defective rows in a CSV format
Write an efficient algorithm for the following assumptions:
• N is an integer within the range [1..200,000);
• S is a string of length N in CSV format;
• there is at least one row;
• each row has the same, positive number of cells;
• each cell consists only of letters and/or digits;
• the first row does not contain a NULL cell.
''' 
def Solution(S):
	rows=S.split("\n")
	header=rows[0]
	data=rows[1:]
	indexes_with_null=set()
	for i, row in enumerate(data):
		cells=row.split(",")

		for j, cell in enumerate(cells):
			if cell=="NULL":
				indexes_with_null.add(j)

		if indexes_with_null:
			data[i]=None 
			indexes_with_null.clear()

	data=filter(None, data)

	return "\n".join([header]+list(data))

