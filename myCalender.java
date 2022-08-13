import java.util.*;
// Approach 1- Brute Force 
class Solution { // TC O(N^2) SC O(N)
    List<int[]> calendar;

    Solution() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

class Solution1{ // TC O(N log N) SC O(N)
    TreeMap<Integer, Integer> calendar;

    Solution1() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

class myCalender{
    public static void main(String[] args) {
        Solution s= new Solution(); 
        System.out.println(s.book(10,20));
        System.out.println(s.book(15,25));
        System.out.println(s.book(20,30));
        Solution1 s1= new Solution1();
        System.out.println(s1.book(10,20));
        System.out.println(s1.book(15,25));
        System.out.println(s1.book(20,30));

    }
}
