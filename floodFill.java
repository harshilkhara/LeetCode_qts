import java.util.*;
class Solution{
	public String floodFill(int[][] image, int sr, int sc, int newColor){
		int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        /*
        for (int i=0; i<image.length;i++){
        	for(int j=0;j<image.length;j++)
        		System.out.print(image[i][j]+ " ");
        }
        */
        //System.out.println(Arrays.deepToString(image));
        return (Arrays.deepToString(image));
	}

	public void dfs(int[][] image, int r, int c, int color, int newColor){
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}

class floodFill{
	public static void main(String [] args){
		int [][] image={{1,1,1},{1,1,0},{1,0,1}};
		int sr=1;
		int sc=1;
		int newColor=2;
		Solution s = new Solution();
		System.out.println(s.floodFill(image,sr,sc,newColor));
	}
}