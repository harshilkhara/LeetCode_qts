import java.util.*;
class Solution { // TC O(N+M+log(alphabets)) SC O(alphabets)
    int representative[] = new int[26];

    // Returns the root representative of the component.
    int find(int x) {
        if (representative[x] == x) {
            return x;
        }

        return representative[x] = find(representative[x]);
    }

    // Perform union if x and y aren't in the same component.
    void performUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        // Make the smaller character representative.
        if (x < y) {
            representative[y] = x;
        } else {
            representative[x] = y;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Make each character representative of itself.
        for (int i = 0; i < 26; i++) {
            representative[i] = i;
        }

        // Perform union merge for all the edges.
        for (int i = 0; i < s1.length(); i++) {
            performUnion(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        String ans = "";
        // Create the answer string with final mappings.
        for (char c : baseStr.toCharArray()) {
            ans += (char)(find(c - 'a') + 'a');
        }

        return ans;
    }
}

class smallestEquivalentString{
    public static void main(String[] args) {
        String s1="parker";
        String s2="morris";
        String baseStr="parser";
        Solution s= new Solution();
        System.out.println(s.smallestEquivalentString(s1,s2,baseStr));
    }
}