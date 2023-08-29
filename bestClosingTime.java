import java.util.*;
// Approach 1- Two pass
class Solution { // TC O(n) SC O(1)
    public int bestClosingTime(String customers) {
        int curPenalty = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                curPenalty++;
            }
        }

        // Start with closing at hour 0, the penalty equals all 'Y' in closed hours.
        int minPenalty = curPenalty;
        int earliestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            
            // If status in hour i is 'Y', moving it to open hours decrement
            // penalty by 1. Otherwise, moving 'N' to open hours increment
            // penatly by 1.
            if (ch == 'Y') {
                curPenalty--;
            } else {
                curPenalty++;
            }

            // Update earliestHour if a smaller penatly is encountered.
            if (curPenalty < minPenalty) {
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }

        return earliestHour;
    }
}

// Approach 2- One pass
class Solution1{ // TC O(n) SC O(1)
    public int bestClosingTime(String customers) {
        // Start with closing at hour 0 and assume the current penalty is 0.
        int minPenalty = 0, curPenalty = 0;
        int earliestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            
            // If status in hour i is 'Y', moving it to open hours decrement
            // penalty by 1. Otherwise, moving 'N' to open hours increment
            // penatly by 1.
            if (ch == 'Y') {
                curPenalty--;
            } else {
                curPenalty++;
            }

            // Update earliestHour if a smaller penatly is encountered.
            if (curPenalty < minPenalty) {
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }

        return earliestHour;
    }
}

class bestClosingTime{
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.bestClosingTime("YYNY"));
        Solution1 s1= new Solution1();
        System.out.println(s1.bestClosingTime("YYNY"));
    }
}