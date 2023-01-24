import java.util.*;
class Pair{
	int row;
	int col; 

	Pair(int row, int col){
		this.row=row;
		this.col=col;
	}
}

// Approach 1- BFS 
class Solution{ // TC O(n^2) SC O(n^2)
	public int snakesAndLadders(int[][] board){
		int n= board.length;
		Pair[] cells= new Pair[n*n+1];
		int[] columns= new int[n];
		for(int i=0; i<n; i++){
			columns[i]=i;
		}
		int label=1;
		for(int row=n-1; row>=0; row--){
			for(int col: columns){
				cells[label++]=new Pair(row,col);
			}
			Collections.reverse(Arrays.asList(columns));
		}
		Queue<Integer> queue=new LinkedList<>();
		int[] dist=new int[n*n+1];
		Arrays.fill(dist,-1);
		dist[1]=0;
		queue.add(1);
		while(!queue.isEmpty()){
			int curr=queue.remove();
			for(int next=curr+1; next<=Math.min(curr+6,n*n); next++){
				int r=cells[next].row, c=cells[next].col;
				int destination=(board[r][c]!=-1) ? board[r][c]: next;
				if(dist[destination]==-1){
					dist[destination]=dist[curr]+1;
					queue.add(destination);
				}
			}
		}
		return dist[n*n];
	}
}

// Same as above code but passes all test cases
class Solution1{
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].row, column = cells[next].col;
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }
}
class snakesAndLadders{
	public static void main(String[] args) {
		int[][] board={	{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},
		{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		Solution s= new Solution();
		System.out.println(s.snakesAndLadders(board));
		Solution1 s1= new Solution1();
		System.out.println(s1.snakesAndLadders(board));
	}
}