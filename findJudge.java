import java.util.*;
// Approach 1- Two Arrays
class Solution{ // TC O(e) SC O(n)
    public int findJudge(int N, int[][] trust) {
    
        if (trust.length < N - 1) {
            return -1;
        }
        
        int[] indegrees = new int[N + 1];
        int[] outdegrees = new int[N + 1];

        for (int[] relation : trust) {
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++; 
        }

        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}

// Approach 2- One Array
class Solution1{ // TC O(e) SC O(n)
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }
        
        int[] trustScores = new int[N + 1];

        for (int[] relation : trust) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++; 
        }
        
        for (int i = 1; i <= N; i++) {
            if (trustScores[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}

class findJudge{
    public static void main(String[] args) {
        int n=3;
        int[][] trust={{1,3},{2,3}};
        Solution s= new Solution();
        System.out.println(s.findJudge(n,trust));
        Solution1 s1= new Solution1();
        System.out.println(s1.findJudge(n,trust));
    }
}