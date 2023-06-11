import java.util.*;
// Approach 1 - Sorted HashMap
class Solution { // TC O(n log n) SC O(n)
    int snapId = 0;
    TreeMap<Integer, Integer>[] historyRecords;
    
    public Solution(int length) {
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<Integer, Integer>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return historyRecords[index].floorEntry(snapId).getValue();
    }
}

class snapShotArray{
    public static void main(String[] args) {
        Solution s= new Solution(3);
        s.set(0,5);
        System.out.println(s.snap());
        s.set(0,6);
        System.out.println(s.get(0,0));
    }
}