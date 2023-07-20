import java.util.*;
// Approach 1- Heap + Set
class Solution { // TC O ((m+n). log n) SC O(n)
    private HashSet<Integer> isPresent;
    private PriorityQueue<Integer> addedIntegers;
    private Integer currentInteger;
    
    public Solution() {
        isPresent = new HashSet<>();
        addedIntegers = new PriorityQueue<>();
        currentInteger = 1;
    }
    
    public int popSmallest() {
        int answer;
        // If there are numbers in the min-heap, 
        // top element is lowest among all the available numbers.
        if (!addedIntegers.isEmpty()) {
            answer = addedIntegers.poll();
            isPresent.remove(answer);
        } 
        // Otherwise, the smallest number of large positive set 
        // denoted by 'currentInteger' is the answer.
        else {
            answer = currentInteger;
            currentInteger += 1;
        }
        return answer;
    }
    
    public void addBack(int num) {
        if (currentInteger <= num || isPresent.contains(num)) {
            return;
        }
        // We push 'num' in the min-heap if it isn't already present.
        addedIntegers.add(num);
        isPresent.add(num);
    }
}

// Approach 2- TreeSet 
class Solution1{ // TC O ((m+n). log n) SC O(n)
    private Set<Integer> set;
    private int currentInteger;

    public Solution1(){
        set=new TreeSet<>();
        currentInteger=1;
    }

    public int popSmallest(){
        int answer;
        if(!set.isEmpty()){
            answer=set.first();
            set.remove(answer);
        } else {
            answer=currentInteger;
            currentInteger++;
        }
        return answer;
    }

    public void addBack(int num){
        if(currentInteger<=num || set.contains(num)) return;

        set.add(num);
    }

}

class smallestInfiniteSet{
    public static void main(String[] args) {
        Solution s=new Solution();
        s.addBack(2);
        System.out.println(s.popSmallest());
        Solution1 s1=new Solution1();
        s.addBack(2);
        System.out.println(s1.popSmallest());
    }
}