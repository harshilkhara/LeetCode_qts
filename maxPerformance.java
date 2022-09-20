import java.util.*;
// Approach 1- Greedy algorithm with Priority Queue
class Pair{
    Integer currEfficiency;
    Integer currSpeed;
    Pair(Integer currEfficiency, Integer currSpeed){
        this.currEfficiency=currEfficiency;
        this.currSpeed=currSpeed;
    }
}

class Solution{ // TC O(n (log n + log k)) SC O(n+k)
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7;
        // build tuples of (efficiency, speed)
        List<Pair> candidates = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            candidates.add(new Pair(efficiency[i], speed[i]));
        }
        // sort the members by their efficiencies
        //Collections.sort(candidates, (a,b)->a[0]-b[0]);
        Collections.sort(candidates, new Comparator<int []>() {
            @Override
            public int compare(int [] a, int [] b) {
                return b[0] - a[0];
            }
        });

        // create a heap to keep the top (k-1) speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long speedSum = 0, perf = 0;
        for (Pair p : candidates) {
            Integer currEfficiency = p.currEfficiency;
            Integer currSpeed = p.currSpeed;
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();
            }
            speedHeap.add(currSpeed);

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        return (int) (perf % modulo);
    }
}

class maxPerformance{
    public static void main(String[] args) {
        int n=6;
        int[] speed={2,10,3,1,5,8};
        int[] efficiency= {5,4,3,9,7,2};
        int k=2;
        Solution s= new Solution();
        System.out.println(s.maxPerformance(n,speed,efficiency,k));
    }
}