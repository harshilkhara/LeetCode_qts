import java.util.*;
// Approach 1- Two HashMaps
class Solution { // TC O(n) SC O(m)
    public boolean wordPattern(String pattern, String s) {
        HashMap <Character, String> map_char = new HashMap<>();
        HashMap <String, Character> map_word = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!map_char.containsKey(c)) {
                if (map_word.containsKey(w)) {
                    return false;
                } else {
                    map_char.put(c, w);
                    map_word.put(w, c);
                }

            } else {
                String mapped_word = map_char.get(c);
                if (!mapped_word.equals(w))
                    return false;
            }
        }

        return true;
    }
}

// Approach 2- One index HashMap
class Solution1{ // TC O(n) SC O(m)
    public boolean wordPattern(String pattern, String s) {
        HashMap map_index = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (map_index.get(c) != map_index.get(w))
                return false;
        }

        return true;
    }
}


class wordPattern{
    public static void main(String[] args) {
        String pattern="abba";
        String x="dog cat cat dog";
        Solution s= new Solution();
        System.out.println(s.wordPattern(pattern,x));
        Solution1 s1= new Solution1();
        System.out.println(s1.wordPattern(pattern,x));
    }
}