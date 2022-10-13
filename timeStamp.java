import java.util.*;
// Approach 1- HashMap + Linear Search
class Solution {
    HashMap<String, HashMap<Integer, String>> keyTimeMap;
    public Solution() {
        keyTimeMap = new HashMap<String, HashMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        // If the 'key' does not exist in map.
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new HashMap<Integer, String>());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        
        // Iterate on time from 'timestamp' to '1'.
        for (int currTime = timestamp; currTime >= 1; --currTime) {
            // If a value for current time is stored in key's bucket we return the value.
            if (keyTimeMap.get(key).containsKey(currTime)) {
                return keyTimeMap.get(key).get(currTime);
            }
        }
        
        // Otherwise no time <= timestamp was stored in key's bucket.
        return ""; 
    }
}

// Approach 2- Sorted Map + Binary Search 
class Solution1{
    HashMap<String, TreeMap<Integer, String>> keyTimeMap;

    Solution1(){
        keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        // If the 'key' does not exist in map.
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new TreeMap<Integer, String>());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        
       Integer floorKey= keyTimeMap.get(key).floorKey(timestamp);
       if (floorKey!=null)
        return keyTimeMap.get(key).get(floorKey);
        
        // Otherwise no time <= timestamp was stored in key's bucket.
        return ""; 
    }

}

class Pair{

    Integer timestamp;
    String value; 

    Pair(Integer timestamp, String value){
        this.timestamp=timestamp;
        this.value=value;
    }
}

// Approach 3- Arrays + Binary Search 
class Solution2{
    HashMap<String, ArrayList<Pair>> keyTimeMap;
    
    public Solution2() {
        keyTimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList<>());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }

        Pair kv= keyTimeMap.get(key).get(0); 

        if (timestamp < kv.timestamp) {
            return "";
        }
        
        // Using binary search on the list of pairs.
        int left = 0;
        int right = keyTimeMap.get(key).size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            Pair temp= keyTimeMap.get(key).get(mid);
            if (temp.timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // If iterator points to first element it means, no time <= timestamp exists.
        if (right == 0) {
            return "";
        }
        
        Pair last= keyTimeMap.get(key).get(right - 1);

        return last.value;
    }
}

class timeStamp{
    public static void main(String[] args) {
        Solution s= new Solution(); 
        s.set("foo","bar",1);
        System.out.println(s.get("foo",1));
        System.out.println(s.get("foo",3));
        s.set("foo","bar",1);

        Solution1 s1= new Solution1(); 
        s1.set("foo","bar",1);
        System.out.println(s1.get("foo",1));
        System.out.println(s1.get("foo",3));
        s1.set("foo","bar",1);

        Solution2 s2= new Solution2(); 
        s2.set("foo","bar",1);
        System.out.println(s2.get("foo",1));
        System.out.println(s2.get("foo",3));
        s2.set("foo","bar",1);
    }
}
