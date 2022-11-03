import java.util.*;

// Approach 1- BFS (using queue) 
class Solution { // TC O(b) SC O(1)
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();
            for (int j = 0; j < nodesInQueue; j++) {
                String node = queue.remove();
                if (node.equals(end)) {
                    return steps;
                }

                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}

class minMutation{
    public static void main(String[] args) {
        String start="AACCGGTT";
        String end="AAACGGTA";
        String[] bank={"AACCGGTA","AACCGCTA","AAACGGTA"};
        Solution s= new Solution();
        System.out.println(s.minMutation(start,end,bank));
    }
}