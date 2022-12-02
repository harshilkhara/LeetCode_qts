import java.util.*;
// Approach 1- Using HashMaps 
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
        }
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }
        List<Integer> word1FrequencyList = new ArrayList<>(word1Map.values());
        List<Integer> word2FrequencyList = new ArrayList<>(word2Map.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);
        return word1FrequencyList.equals(word2FrequencyList);
    }
}

// Approach 2- Arrays to store frequency 
class Solution1{
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int word1Map[] = new int[26];
        int word2Map[] = new int[26];
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }
        // 1st condition: swapping 
        for (int i = 0; i < 26; i++) {
            if ((word1Map[i] == 0 && word2Map[i] > 0) ||
                (word2Map[i] == 0 && word1Map[i] > 0)) {
                return false;
            }
        }
        // 2nd condition: occurences (sorting the values)
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        
        return Arrays.equals(word1Map, word2Map);
    }
}

// Approach 3- Using Bitwise operation and arrays to store frequency 
class Solution2{
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int word1Map[] = new int[26];
        int word2Map[] = new int[26];
        int word1Bit = 0;
        int word2Bit = 0;
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
            word1Bit = word1Bit | (1 << (c - 'a'));
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
            word2Bit = word2Bit | (1 << (c - 'a'));
        }
        if (word1Bit != word2Bit) {
            return false;
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        for (int i = 0; i < 26; i++) {
            if (word1Map[i] != word2Map[i]) {
                return false;
            }
        }
        return true;
    }
}

class closeStrings{
    public static void main(String[] args) {
        String word1="cabbba";
        String word2="abbccc";
        Solution s= new Solution();
        System.out.println(s.closeStrings(word1, word2));
        Solution1 s1= new Solution1();
        System.out.println(s1.closeStrings(word1, word2));
        Solution2 s2= new Solution2();
        System.out.println(s2.closeStrings(word1, word2));
    }
}