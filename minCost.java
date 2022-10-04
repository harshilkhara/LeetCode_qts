// Apporach 1- Two Pointers 
class Solution { // TC O(n)  SC O(n)
    public int minCost(String colors, int[] neededTime) {
        // Initalize two pointers i, j.
        int totalTime = 0;
        int i = 0, j = 0;
        
        while (i < neededTime.length && j < neededTime.length) {
            int currTotal = 0, currMax = 0;
            
            // Find all the balloons having the same color as the 
            // balloon indexed at i, record the total removal time 
            // and the maximum removal time.
            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                j++;
            }
            
            // Once we reach the end of the current group, add the cost of 
            // this group to total_time, and reset two pointers.
            totalTime += currTotal - currMax;
            i = j;
        }
        return totalTime;    
    }
}

// Approach 2- Advanced 1- Pass 
class Solution1{ // TC O(n)  SC O(1)
    public int minCost(String colors, int[] neededTime) {
        // totalTime: total time needed to make rope colorful;
        // currMaxTime: maximum time of a balloon needed.
        int totalTime = 0, currMaxTime = 0;
        
        // For each balloon in the array:
        for (int i = 0; i < colors.length(); ++i) {
            // If this balloon is the first balloon of a new group
            // set the currMaxTime as 0.
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                currMaxTime = 0;
            }
            
            // Increment totalTime by the smaller one.
            // Update currMaxTime as the larger one.
            totalTime += Math.min(currMaxTime, neededTime[i]);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }
        
        // Return totalTime as the minimum removal time.
        return totalTime;
    }
}

class minCost{
    public static void main(String[] args) {
        String colors= "abaac";
        int[] neededTime= {1,2,3,4,5};
        Solution s = new Solution();
        System.out.println(s.minCost(colors,neededTime));
        Solution1 s1 = new Solution1();
        System.out.println(s1.minCost(colors,neededTime));
    }
}