import java.util.*;
// Approach 1- Categorize by sorted string 
class Solution { // TC O(n k log k) SC O(N*K)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) 
                ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

// Approach 2- Categorize by count 
class Solution1{ // TC O(n*k) SC O(n*k)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) 
                count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) 
                ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

class groupAnagrams{
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        Solution s= new Solution();
        System.out.println(s.groupAnagrams(strs));
        Solution1 s1= new Solution1();
        System.out.println(s1.groupAnagrams(strs));
    }
}