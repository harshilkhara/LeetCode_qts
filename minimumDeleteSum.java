import java.util.*;
class Pair{
    int i, j;
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
// Approach 1- Top Down DP
class Solution { // TC O(m.n) SC O(m.n)
    Map<Pair, Integer> memo=new HashMap<>(); 
    String s1;
    String s2;
    public int minimumDeleteSum(String s1, String s2) {
        this.s1=s1;
        this.s2=s2;

        return computeCost(s1.length()-1, s2.length()-1);
    }

    public int computeCost(int i, int j){
        if(i<0 && j<0) return 0; 

        Pair key=new Pair(i, j);
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(i<0){
            memo.put(key, s2.charAt(j)+computeCost(i, j-1));
            return memo.get(key);
        }

        if(j<0){
            memo.put(key, s1.charAt(i)+computeCost(i-1, j));
            return memo.get(key);
        }

        if(s1.charAt(i)==s2.charAt(j)){
            memo.put(key, computeCost(i-1, j-1));
        } else{
            memo.put(key, Math.min(
                s1.charAt(i) + computeCost(i-1, j),
                s2.charAt(j) + computeCost(i, j-1)
            ));
        }
        return memo.get(key);
    }
}

// Approach 2- Bottom Up DP
class Solution1{ // TC O(m.n) SC O(m.n)
    public int minimumDeleteSum(String s1, String s2) {
        
        // Prepare the two-dimensional array
        int m = s1.length(), n = s2.length();
        int[][] computeCost = new int[m + 1][n + 1];

        // Fill in the base case values
        for (int i = 1; i <= m; i++) {
            computeCost[i][0] = computeCost[i-1][0] + s1.charAt(i-1);
        }
        for (int j = 1; j <= n; j++) {
            computeCost[0][j] = computeCost[0][j-1] + s2.charAt(j-1);
        }
        
        // Fill the remaining cells using the Bellman Equation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    computeCost[i][j] = computeCost[i-1][j-1];
                } else {
                    computeCost[i][j] = Math.min(
                        s1.charAt(i-1) + computeCost[i-1][j],
                        s2.charAt(j-1) + computeCost[i][j-1]
                    );
                }
            }
        }
        
        // Return the answer for entire input strings
        return computeCost[m][n];
    }
}

class minimumDeleteSum{
    public static void main(String[] args) {
        String x1="sea";
        String x2="eat";
        Solution s= new Solution();
        System.out.println(s.minimumDeleteSum(x1, x2));
        Solution1 s1= new Solution1();
        System.out.println(s1.minimumDeleteSum(x1, x2));
    }
}