import java.util.*;
// Approach 1- Brute Force 
class Solution{ // TC O(n^2) SC O(1)
	public int[] dailyTemperatures(int[] temperatures){
		int[] ans= new int[temperatures.length];
		for(int i=0; i<temperatures.length; i++){
			for(int j=i+1; j<temperatures.length; j++){
				if(temperatures[j]>temperatures[i]){
					ans[i]=j-i;
					break;
				}
			}
		}
		return ans;
	}
}

/* Approach 2- Decreasing Monotonic Stack

Monotonic stacks are a good option when a problem involves 
comparing the size of numeric elements, with their order being relevant.
*/

class Solution1{ // TC O(n) SC O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        
        return answer;
    }
}

// Approach 3- Array, Optimizied space
class Solution2{ // TC O(n) SC O(1)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int answer[] = new int[n];
        
        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }
        
        return answer;
    }
}

class dailyTemperatures{
	public static void main(String[] args) {
		int[] temperatures={73,74,75,71,69,72,76,73};
		Solution s= new Solution();
		System.out.println(Arrays.toString(s.dailyTemperatures(temperatures)));
		Solution1 s1= new Solution1();
		System.out.println(Arrays.toString(s1.dailyTemperatures(temperatures)));
	}
}
