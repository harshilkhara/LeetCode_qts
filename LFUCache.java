import java.util.*;
class Pair{
    int freq;
    int val;

    Pair(int freq, int val){
        this.freq=freq;
        this.val=val;
    }
}

// Approach 1- Maintaing two HashMaps
class Solution{ // TC O(1) SC O(n)
    // key: original key, value: frequency and original value.
    private Map<Integer, Pair> cache;
    // key: frequency, value: All keys that have the same frequency.
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minf;
    private int capacity;
    

    public Solution(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minf = 0;
        this.capacity = capacity;
    }

    private void insert(int key, int frequency, int value) {
        cache.put(key, new Pair(frequency, value));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }
    
    public int get(int key) {
        Pair frequencyAndValue = cache.get(key);
        if (frequencyAndValue == null) {
            return -1;
        }
        final int frequency = frequencyAndValue.freq;
        final Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if (minf == frequency && keys.isEmpty()) {
            ++minf;
        }
        final int value = frequencyAndValue.val;
        insert(key, frequency + 1, value);   
        return value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Pair frequencyAndValue = cache.get(key);
        if (frequencyAndValue != null) {
            cache.put(key, new Pair(frequencyAndValue.freq, value));
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            final Set<Integer> keys = frequencies.get(minf);
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
        }
        minf = 1;
        insert(key, 1, value);
    }
}

class Solution1{
    Map<Integer, Pair> cache;
    Map<Integer, LinkedHashSet<Integer>> frequencies;
    int minf;
    int capacity;
    
    public Solution1(int capacity){
        cache=new HashMap<>();
        frequencies=new HashMap<>();
        this.capacity=capacity;
        minf=0;
    }
    
    public void insert(int key, int frequency, int val){
        cache.put(key, new Pair(frequency,val));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }
    
    
    public int get(int key){
        Pair p=cache.get(key);
        if (p==null) return -1; 
        
        int frequency=p.freq;
        Set<Integer> keys=frequencies.get(frequency);
        keys.remove(key);
        if(minf==frequency && keys.isEmpty()){
            ++minf;
        }
        int value=p.val;
        insert(key,frequency+1,value);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Pair p = cache.get(key);
        if (p != null) {
            cache.put(key, new Pair(p.freq, value));
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            Set<Integer> keys = frequencies.get(minf);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
        }
        minf = 1;
        insert(key, 1, value);
    }
}

class LFUCache{
    public static void main(String[] args) {
        Solution s= new Solution(2);
        s.put(1,1);
        s.put(2,2);
        System.out.println(s.get(1));
        s.put(3,3);
        System.out.println(s.get(2));
        System.out.println(s.get(3));
        s.put(4,4);
        System.out.println(s.get(1));
        System.out.println(s.get(3));
        System.out.println(s.get(4));
        //
        Solution1 s1= new Solution1(2);
        s1.put(1,1);
        s1.put(2,2);
        System.out.println(s1.get(1));
        s1.put(3,3);
        System.out.println(s1.get(2));
        System.out.println(s1.get(3));
        s1.put(4,4);
        System.out.println(s1.get(1));
        System.out.println(s1.get(3));
        System.out.println(s1.get(4));

    }
}