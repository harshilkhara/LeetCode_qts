import java.util.*;
// Approach 1- Greedy  
class Solution { // TC O(n log n) SC O(log n)
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if (costs[0]>coins) return 0;
        int icecream=0;
        for (int cost: costs){
            if (coins>0 && cost<=coins){
                coins-=cost;
                icecream++;
            }
        }
        return icecream;
    }
}

// Approach 2- Counting Sort (Greedy)
class Solution1{ // TC O(n+m) SC O(m)
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int icecreams = 0;

        int m = costs[0];
        for (int cost : costs) {
            m = Math.max(m, cost);
        }

        int[] costsFrequency = new int[m + 1];
        for (int cost : costs) {
            costsFrequency[cost]++;
        }

        for (int cost = 1; cost <= m; ++cost) {
            // No ice cream is present costing 'cost'.
            if (costsFrequency[cost] == 0) {
                continue;
            }
            // We don't have enough 'coins' to even pick one ice cream.
            if (coins < cost) {
                break;
            }
            
            // Count how many icecreams of 'cost' we can pick with our 'coins'.
            // Either we can pick all ice creams of 'cost' or we will be limited by remaining 'coins'.
            int count = Math.min(costsFrequency[cost], coins / cost);
            // We reduce price of picked ice creams from our coins.
            coins -= cost * count;
            icecreams += count;
        }

        return icecreams;
    }
}

class maxIceCream{
    public static void main(String[] args) {
        int[] costs={7,3,3,6,6,6,10,5,9,2};
        int coins=56;
        Solution s= new Solution();
        System.out.println(s.maxIceCream(costs,coins));
        Solution1 s1= new Solution1();
        System.out.println(s1.maxIceCream(costs,coins));
    }
}