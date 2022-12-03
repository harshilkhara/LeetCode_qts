import java.util.*;
// Approach 1- HashMap and Sort 
class Solution{ // TC O(n log n) SC O(n)
	public String frequencySort(String s){
		Map<Character, Integer> map =new HashMap<>();

		// Count the occurences 
		for(char c: s.toCharArray()){
			map.put(c,map.getOrDefault(c,0)+1);
		}

		// Make a list of the keys, sorted by frequency.
		List<Character> freqList= new ArrayList<>(map.keySet());
		Collections.sort(freqList, (a,b)->map.get(b)-map.get(a));

		// Convert the counts into a string with a sb.
		StringBuilder sb= new StringBuilder();
		for(char c: freqList){
			int copies=map.get(c);
			for(int i=0; i<copies; i++){
				sb.append(c);
			}
		}
		return sb.toString();
	}
}

// Approach 2- MultiSet and Bucket Sort 
class Solution1{ // TC O(n) SC O(n)
	public String frequencySort(String s) {
	    if (s == null || s.isEmpty()) return s;
	    
	    // Count up the occurances.
	    Map<Character, Integer> counts = new HashMap<>();
	    for (char c : s.toCharArray()) {
	        counts.put(c, counts.getOrDefault(c, 0) + 1);
	    }
	    
	    int maximumFrequency = Collections.max(counts.values());
	    
	    // Make the list of buckets and apply bucket sort.
	    List<List<Character>> buckets = new ArrayList<>();
	    for (int i = 0; i <= maximumFrequency; i++) {
	        buckets.add(new ArrayList<Character>());
	    }
	    for (Character key : counts.keySet()) {
	        int freq = counts.get(key);
	        buckets.get(freq).add(key);
	    }

	    // Build up the string. 
	    StringBuilder sb = new StringBuilder();
	    for (int i = buckets.size() - 1; i >= 1; i--) {
	        for (Character c : buckets.get(i)) {
	            for (int j = 0; j < i; j++) {
	                sb.append(c);
	            }
	        }
	    }
	    return sb.toString();
	}
}

class frequencySort{
	public static void main(String[] args) {
		String x= "tree";
		Solution s= new Solution();
		System.out.println(s.frequencySort(x));
		Solution1 s1= new Solution1();
		System.out.println(s1.frequencySort(x));
	}
}