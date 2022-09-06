import java.util.*;
// Approach 1- DFS (Recursive) [call-stack]
class Solution { // TC O(2^n) SC O(2^n)
    public List<Integer> numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)) ;

        List<Integer> results = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            this.DFS(N - 1, num, K, results);

        // convert the ArrayList to int[]
        //return results.stream().mapToInt(i->i).toArray();
        return results;
    }

    protected void DFS(int N, int num, int K, List<Integer> results) {
        if (N == 0) {
            results.add(num);
            return;
        }
        List<Integer> nextDigits = new ArrayList<>();

        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + K);
        if (K != 0)
            nextDigits.add(tailDigit - K);
        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                this.DFS(N - 1, newNum, K, results);
            }
        }
    }
}

// Approach 2- BFS [using queues] 
class Solution1{ // TC O(2^n) SC O(2^n)
    public List<Integer> numsSameConsecDiff(int N, int K) {

        if (N == 1)
            return new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9)); 

        List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(int level = 1; level < N; ++ level) {
            ArrayList<Integer> nextQueue = new ArrayList<>();
            // iterate through each number within the level
            for (Integer num : queue) {
                Integer tailDigit = num % 10;

                ArrayList<Integer> nextDigits = new ArrayList<>();
                nextDigits.add(tailDigit + K);
                if (K != 0)
                    nextDigits.add(tailDigit - K);
                for (Integer nextDigit : nextDigits) {
                    if (0 <= nextDigit && nextDigit < 10) {
                        Integer newNum = num * 10 + nextDigit;
                        nextQueue.add(newNum);
                    }
                }
            }
            // prepare for the next level
            queue = nextQueue;
        }

        //return queue.stream().mapToInt(i->i).toArray();
        return queue;
    }
}


class numsSameConsecDiff{
    public static void main(String[] args) {
        int n=3;
        int k=7;
        Solution s= new Solution();
        Solution1 s1= new Solution1();
        System.out.println(s.numsSameConsecDiff(n,k));
        System.out.println(s1.numsSameConsecDiff(n,k));
    }

}
