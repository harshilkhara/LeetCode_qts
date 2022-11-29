import java.util.*;
// Approach 1- Using set itself 
// It is not right though because getRandom() is TC O(n) and 
// not O(1)
class Solution { // TC O(n) SC O(n)
    Set<Integer> set;
    Random rand;
    public Solution() {
        set= new HashSet<>();
        rand= new Random();
    }
    
    public boolean insert(int val) { // TC O(1)
        if (set.contains(val)){
            return false;
        }
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) { // TC O(1)
        if(!set.contains(val)){
            return false;
        }
        set.remove(val);
        return true;
        
    }
    
    public int getRandom() { // TC O(n)
        List<Integer> list= new ArrayList<>(set);
        return list.get(rand.nextInt(list.size()));
        
    }
}

// Approach 2- HashMap and ArrayList
class Solution1 { // TC O(1) SC O(1)
  Map<Integer, Integer> dict;
  List<Integer> list;
  Random rand = new Random();

  /** Initialize your data structure here. */
  public Solution1() {
    dict = new HashMap<>();
    list = new ArrayList<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (dict.containsKey(val)) return false;

    dict.put(val, list.size());
    list.add(list.size(), val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (! dict.containsKey(val)) return false;

    // move the last element to the place idx of the element to delete
    int lastElement = list.get(list.size() - 1);
    int idx = dict.get(val);
    list.set(idx, lastElement);
    dict.put(lastElement, idx);
    // delete the last element
    list.remove(list.size() - 1);
    dict.remove(val);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}

class randomizedSet{
    public static void main(String[] args) {
        Solution rs= new Solution();
        System.out.println(rs.insert(3));
        System.out.println(rs.insert(2));
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.remove(2));
        System.out.println(rs.getRandom());
        // 2nd approach
        Solution1 rs1= new Solution1();
        System.out.println(rs1.insert(3));
        System.out.println(rs1.insert(2));
        System.out.println(rs1.insert(1));
        System.out.println(rs1.remove(2));
        System.out.println(rs1.remove(2));
        System.out.println(rs1.getRandom());
    }
}
