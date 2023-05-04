import java.util.*;
// Approach 1- Two Queues
class Solution { // TC O(n) SC O(n)
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            
            int rTurn = rQueue.poll();
            int dTurn = dQueue.poll();

            if (dTurn < rTurn) {
                dQueue.add(dTurn + n);
            } else {
                rQueue.add(rTurn + n);
            }
        }

        return !rQueue.isEmpty() ? "Radiant" : "Dire";
    }
}

class predictPartyVictory{
    public static void main(String[] args) {
        String senate="RDD";
        Solution s= new Solution();
        System.out.println(s.predictPartyVictory(senate));
    }
}