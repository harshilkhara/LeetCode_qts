import java.util.*;
// Approach 1- Decrementing till the frequencies are unique
class Solution { // TC O(N+K^2) // SC O(K)
    public int minDeletions(String s) {
        // Store the frequency of each character
        int[] frequencies = new int[26]; 
        for (int i=0; i < s.length(); i++){
            frequencies[s.charAt(i)-'a']++;
        }
        int deleteCount=0; 
        // Use a set to store the frequencies we have already seen
        HashSet<Integer> seenFrequencies= new HashSet<>();
        
        for (int i=0; i < 26; i++){
            // Keep decrementing the frequency until it is unique
            while(frequencies[i]>0 && seenFrequencies.contains(frequencies[i])){
                frequencies[i]--;
                deleteCount++;
            }
            // Add the newly occupied frequency to the set
            seenFrequencies.add(frequencies[i]);
        }
        return deleteCount;    
    }
}
// Approach 2- Priority Queue (Max Heap)
class Solution1{ // TC O(N + K^2 log K) // SC O(K)
    public int minDeletions(String s) {
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        // Add the frequencies to the priority queue
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); OR 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); //not necessary to give a length
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                pq.add(frequency[i]);
            }
        }
        
        int deleteCount = 0;
        while (pq.size() > 1) {
            int topElement  = pq.remove();
            
            // If the top two elements in the priority queue are the same
            if (topElement == pq.peek()) {
                // Decrement the popped value and push it back into the queue
                if (topElement - 1 > 0) {
                    pq.add(topElement - 1);
                }
                deleteCount++;
            }
        }
        return deleteCount;
    }
}

// Approach 3- Sorting 
class Solution2{ // TC O(N + K log K) // SC O(K)
    public int minDeletions(String s) {
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        Arrays.sort(frequency);
        
        int deleteCount = 0;
        // Maximum frequency the current character can have
        int maxFreqAllowed = s.length();
        
        // Iterate over the frequencies in descending order
        for (int i = 25; i >= 0 && frequency[i] > 0; i--) {
            // Delete characters to make the frequency equal the maximum frequency allowed
            if (frequency[i] > maxFreqAllowed) {
                deleteCount += frequency[i] - maxFreqAllowed;
                frequency[i] = maxFreqAllowed;
            }
            // Update the maximum allowed frequency
            maxFreqAllowed = Math.max(0, frequency[i] - 1);
        }
        return deleteCount;
    }     
}

class minDeletions{
    public static void main(String[] args){
        String s= "aaabbbcc";
        Solution x= new Solution();
        System.out.println(x.minDeletions(s));
    }
}