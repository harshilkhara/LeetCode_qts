import java.util.*;
// Approach 1- Brute Force
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0, n = grid.length;
        
        // Check each row r against each column c.
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                boolean match = true;

                // Iterate over row r and column c.
                for (int i = 0; i < n; ++i) {
                    if (grid[r][i] != grid[i][c]) {
                        match = false;
                        break;
                    }
                }

                // If row r equals column c, increment count by 1.
                count += match ? 1 : 0;
            }
        }
        
        return count;
    }
}

// Approach 2- HashMap
class Solution1{
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        // Add up the frequency of each column in map.
        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}

// Approach 3- Trie
class TrieNode{
    int count=0;
    Map<Integer, TrieNode> children;

    TrieNode(){
        this.count=0;
        this.children=new HashMap<>();
    }
}

class Trie{
    TrieNode root;

    Trie(){
        this.root=new TrieNode();
    }

    public void insert(int[] array){
        TrieNode curr=root;
        for(int n: array){
            if (!curr.children.containsKey(n)){
                curr.children.put(n, new TrieNode());
            }
            curr=curr.children.get(n);
        }
        curr.count++;
    }

    public int search(int[] array){
        TrieNode curr=root;
        for(int n: array){
            if(curr.children.containsKey(n)){
                curr=curr.children.get(n);
            } else {
                return 0;
            }
        }
        return curr.count;

    }
}

class Solution2{
    public int equalPairs(int[][] grid){
        int count=0;
        Trie t=new Trie();
        for(int[] row: grid){
            t.insert(row);
        }

        for(int c=0; c<grid[0].length; c++){
            int[] cols=new int[grid[0].length];
            for(int r=0; r<grid.length; r++){
                cols[r]=grid[r][c];
            }
            count+=t.search(cols);
        }
        return count;
    }
}

class equalPairs{
    public static void main(String[] args) {
        int[][] grid={{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        Solution s= new Solution();
        System.out.println(s.equalPairs(grid));
        Solution1 s1= new Solution1();
        System.out.println(s.equalPairs(grid));
        Solution2 s2= new Solution2();
        System.out.println(s.equalPairs(grid));        
    }
}