//Approach 1- Recursion 
import java.util.*;
class Solution{    // TC O(2^n) SC O(n)
	public int fib(int n){
		if (n<=1)
			return n;

		return fib(n-1)+fib(n-2);
	}
}

// Approach 2- Climbing stairs like (Iterative Bottom Up DP)
class Solution1{   // TC O(N) // SC O(1)
    public int fib(int n) {
        if (n<=1)
            return n;
        int one=1;
        int two=0; 
        for (int i=2; i<=n;i++){
            int temp= one;
            one = one + two; 
            two= temp;
        }
        return one;
    }
}

// Approach 3- Bottom Up DP 

class Solution2{              // TC O(N) // SC O(N)
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
                  
        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[N];
    }
}

// Approach 4- Top Down DP 

class Solution3{ // TC O(N) // SC O(N)
    // Creating a hash map with 0 -> 0 and 1 -> 1 pairs
    private Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    public int fib(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        cache.put(N, fib(N - 1) + fib(N - 2));
        return cache.get(N);
    }
}
// Approach 5- Matrix 

class Solution4{ // TC O(log n) // SC O(log n)
    int fib(int N) {
        if (N <= 1) {
          return N;
        }
        int[][] A = new int[][]{{1, 1}, {1, 0}};
        matrixPower(A, N - 1);

        return A[0][0];
    }

    void matrixPower(int[][] A, int N) {
        if (N <= 1) {
          return;
        }
        matrixPower(A, N / 2);
        multiply(A, A);

        int[][] B = new int[][]{{1, 1}, {1, 0}};
        if (N % 2 != 0) {
            multiply(A, B);
        }
    }

    void multiply(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }
}
class fib{
	public static void main(String [] args){
		int n= 7; 
		Solution s= new Solution();
		System.out.println(s.fib(n));
		Solution1 s1= new Solution1();
		System.out.println(s1.fib(n));
		Solution2 s2= new Solution2();
		System.out.println(s2.fib(n));
		Solution3 s3= new Solution3();
		System.out.println(s3.fib(n));
		Solution4 s4= new Solution4();
		System.out.println(s4.fib(n));
	}
}