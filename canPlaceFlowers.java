import java.util.*;
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i=0; i<flowerbed.length; i++){
            if (flowerbed[i]==0){
                boolean left= (i==0) || (flowerbed[i-1]==0);
                boolean right=(i==flowerbed.length-1) || (flowerbed[i+1]==0);
                
                if (left && right){
                    n--;
                    flowerbed[i]=1;
                    if(n<=0) return true;
                }
            }
        }
        return n<=0;
    }
}

class canPlaceFlowers{
    public static void main(String[] args) {
        int[] flowerbed={1,0,0,0,1};
        int n=1;
        Solution s= new Solution();
        System.out.println(s.canPlaceFlowers(flowerbed, n));
    }
}