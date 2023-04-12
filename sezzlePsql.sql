'''
Codility is a company that creates programming tasks which are solved by candidates. After 
submitting their solution to a task, each candidate receives a report containing the number of 
points their solution scored, which is an integer between 0 and 100.
You are given two tables, tasks and reports, with the following structure: create table tasks (
id integer not null, name varchar (40) not null, unique (id)
create table reports ( id integer not null, task_id integer not null, candidate varchar (40) 
	not null, score integer not null, unique (id)
):
Your task is to write an SQL query which assigns a difficulty rating to each task having at 
least one solution. The difficulty of the task depends on the average score of all candidates 
solutions submitted for this task. It is possible that one candidate have submitted multiple 
solutions for the same task in this case, all of those solutions should be included in the average.
There are three difficulties: "Easy*, "Medium" and "Hard"*.
• If the average score for the task is lower than or equal to 20, then its difficulty is "Hard*.
• If the average is higher than 20 but lower than or equal to 60, then its difficulty is Medium*.
If the average is higher than 60, its difficulty is "Easy".
For example, if the average score of the task is 50, then its difficulty is "Medium" 
because the average score is greater than 20 but less then 60.
Your query should return a table containing three columns: task_id (iD of task), 
task_ name (name of task) and difficulty - the difficulty of the task, 
which is one of three possible strings: "Easy" "Medium" or "Hard* Rows should be 
ordered by increasing task_id. If no solutions exist for some task that task should 
not appear in your table.
'''

SELECT 
	tasks.id as task_id,
	tasks.name as task_name,
	CASE 
	WHEN AVG(SCORE)<=20 THEN 'Hard'
	WHEN AVG(SCORE)<=60 THEN 'Medium'
	ELSE 'EASY'
	END AS difficulty 
FROM 
	tasks 
	JOIN report on tasks.id=report.task_id 
GROUP BY 
	tasks.id,
	tasks.name 
HAVING 
	COUNT(*)>0
ORDER BY 
	task_id ASC; 
