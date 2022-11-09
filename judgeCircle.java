class Solution {
    public boolean judgeCircle(String moves) { // TC O(n) SC O(1)
        int x=0,y=0;
        for (char c: moves.toCharArray()){
            if (c=='U')
                y++;
            if (c=='D')
                y--;
            if(c=='L')
                x--;
            if (c=='R')
                x++;
        }
        return x==0 && y==0;
    }
}

class judgeCircle{
    public static void main(String[] args) {
        String moves="RRDD";
        Solution s= new Solution();
        System.out.println(s.judgeCircle(moves));
    }
}