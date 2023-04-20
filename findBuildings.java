import java.util.*;
// Approach 1- Iterating from right to left and updating the maxHeight
class Solution{ // TC O(n) SC O(n)
    public int[] findBuildings(int[] heights) {
    
    int maxHeight = Integer.MIN_VALUE;
    ArrayList<Integer> result = new ArrayList<>();
    
    for(int i = heights.length - 1; i > -1; i--){
        
        int cur = heights[i];
                    
        if(cur <= maxHeight){
            continue;
        }
        result.add(i);
        maxHeight = Math.max(maxHeight, heights[i]);
    }
    
    int[] answer = new int[result.size()];
    for(int i = 0; i < result.size(); i++){
        answer[i] = result.get(result.size() - 1 - i);
        }
    
    return answer;   
    }

}

// Approach 2- Iterating from left to right 
// This behaves like a stack too if you think about it 
class Solution1{ // TC O(n) SC O(n)
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        
        for (int current = 0; current < n; ++current) {
            // If the current building is taller, 
            // it will block the shorter building's ocean view to its left.
            // So we pop all the shorter buildings that have been added before.
            while (!list.isEmpty() && heights[list.get(list.size() - 1)] <= heights[current]) {
                list.remove(list.size() - 1);
            }
            list.add(current);
        }
 
        // Push elements from list to answer array.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

// Approach 3- Monotonic Stack 
class Solution2{ // TC O(n) SC O(n)
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        
        // Monotonically decreasing stack.
        Stack<Integer> stack = new Stack<>();  
        for (int current = n - 1; current >= 0; --current) {
            // If the building to the right is smaller, we can pop it.
            while (!stack.isEmpty() && heights[stack.peek()] < heights[current]) {
                stack.pop();
            }
            
            // If the stack is empty, it means there is no building to the right 
            // that can block the view of the current building.
            if (stack.isEmpty()) { 
                list.add(current);
            }
            
            // Push the current building in the stack.
            stack.push(current);
        }
 
        // Push elements from list to answer array in reverse order.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(list.size() - 1 - i);
        }
        
        return answer;
    }
}

// Approach 4- Monotonic Stack Space optimized
// Similar to Approach 1 
class Solution3{ // TC O(n) SC O(n)
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        int maxHeight = -1;
        
        for (int current = n - 1; current >= 0; --current) {
            // If there is no building higher (or equal) than the current one to its right,
            // push it in the list.
            if (maxHeight < heights[current]) {
                list.add(current);
                
                // Update max building till now.
                maxHeight = heights[current];
            }
        }
        
        // Push building indices from list to answer array in reverse order.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(list.size() - 1 - i);
        }
        
        return answer;
    }
}
    
class findBuildings{
    public static void main(String[] args) {
        int[] heights={4,2,3,1};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.findBuildings(heights)));
        Solution1 s1= new Solution1();
        System.out.println(Arrays.toString(s1.findBuildings(heights)));
        Solution2 s2= new Solution2();
        System.out.println(Arrays.toString(s2.findBuildings(heights)));
        Solution3 s3= new Solution3();
        System.out.println(Arrays.toString(s3.findBuildings(heights)));
    }
}
