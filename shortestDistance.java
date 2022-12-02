import java.util.*;
class Solution { // TC O(m*n) SC O(1)
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1=-1, i2=-1;
        int distance=wordsDict.length;
        for (int i=0; i<wordsDict.length; i++){
            if (wordsDict[i].equals(word1)){
                i1=i;
            } else if (wordsDict[i].equals(word2)){
                i2=i;
            }
            if (i1!=-1 && i2!=-1){
                distance=Math.min(distance,Math.abs(i1-i2));
            }
        }
        return distance;
    }
}

class shortestDistance{
    public static void main(String[] args) {
        String[] wordsDict={"practice", "makes", "perfect", "coding", "makes"};
        String word1= "coding";
        String word2= "practice";
        Solution s= new Solution();
        System.out.println(s.shortestDistance(wordsDict,word1,word2));
    }
}