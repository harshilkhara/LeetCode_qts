import java.util.*;
// Approach 1- Sorting 
class Solution { // TC O(n log n)  SC O(log n) 
    public int numberOfWeakCharacters(int[][] properties) {
        // Sort in ascending order of attack, 
        // If attack is same sort in descending order of defense
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : a[0] - b[0]);
        
        int weakCharacters = 0;
        int maxDefense = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            // Compare the current defense with the maximum achieved so far
            if (properties[i][1] < maxDefense) {
                weakCharacters++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        
        return weakCharacters;
    }
}

// Approach 2- Greedy 
class Solution1{ // TC O(N+K) SC O(K)
    public int numberOfWeakCharacters(int[][] properties) {
        int maxAttack = 0;
        // Find the maximum attack value
        for (int[] property : properties) {
            int attack = property[0];
            maxAttack = Math.max(maxAttack, attack);
        }
        
        int maxDefense[] = new int[maxAttack + 2];
        // Store the maximum defense for an attack value
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];
            
            maxDefense[attack] = Math.max(maxDefense[attack], defense);
        }

        // Store the maximum defense for attack greater than or equal to a value
        for (int i = maxAttack - 1; i >= 0; i--) {
            maxDefense[i] = Math.max(maxDefense[i], maxDefense[i + 1]);
        }
        
        int weakCharacters = 0;
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];
            
            // If their is a greater defense for properties with greater attack
            if (defense < maxDefense[attack + 1]) {
                weakCharacters++;
            }
        }
        
        return weakCharacters;
    }
}


class numberOfWeakCharacters{
    public static void main(String[] args) {
        int [][] properties= {{5,5},{6,3},{3,6}};
        Solution s= new Solution();
        System.out.println(s.numberOfWeakCharacters(properties));
        Solution1 s1= new Solution1();
        System.out.println(s1.numberOfWeakCharacters(properties));

    }
}