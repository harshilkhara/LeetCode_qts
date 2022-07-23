import java.util.*;

//Approach 1- Detect Cycles with HashSet 
class Solution{ // TC O(log n) SC O(log n)

	 private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
	
}

// Approach 2- Floyd's cycle finding algorithm 

class Solution1{ // TC O(log n) SC O(1)

     public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}

class isHappy{
	public static void main(String[] args) {
		Solution s= new Solution();
		Solution1 s1= new Solution1();
		int n=19;
		int n1=7;
		System.out.println(s.isHappy(n));
		System.out.println(s.isHappy(n1));
	}
}