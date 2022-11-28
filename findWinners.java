import java.util.*;
// Approach 1- HashMap 
class Solution { // TC O(n log n) SC O(n)
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int[] match: matches){
            int winner= match[0], loser=match[1];
            map.put(winner,map.getOrDefault(winner,0));
            map.put(loser,map.getOrDefault(loser,0)+1);
        }
        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player: map.keySet()){
            if(map.get(player)==0){
                ans.get(0).add(player);
            } else if (map.get(player)==1){
                ans.get(1).add(player);
            }
        }
        
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
// Approach 2- Counting with Array 
// Idea of counting sort behind it
class Solution1{ // TC O(n+k) SC O(k)
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lossesCount = new int[100001];
        Arrays.fill(lossesCount, -1);

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            if (lossesCount[winner] == -1) {
                lossesCount[winner] = 0;
            }
            if (lossesCount[loser] == -1) {
                lossesCount[loser] = 1;
            } else {
                lossesCount[loser]++;
            }
        }

        List<List<Integer>> answer =
            Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int i = 1; i < 100001; ++i) {
            if (lossesCount[i] == 0) {
                answer.get(0).add(i);
            } else if (lossesCount[i] == 1) {
                answer.get(1).add(i);
            }
        }

        return answer;
    }
}

class findWinners{
    public static void main(String[] args) {
        int[][] matches={{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        Solution s= new Solution();
        System.out.println(s.findWinners(matches));
        Solution1 s1= new Solution1();
        System.out.println(s1.findWinners(matches));
    }
}