/*
 * ===> Question: 3: (LeetCode Question: Number:- 733 (Easy))
 * 
 * Given a m*n integer grid image where image[i][j] represents the pixel value of the image.
 * 
 * You are also given three integers sr(Starting Row), sc(Starting Coloumn) and color. You should perform
 * a flood fill on the image starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of
 * the same color as the starting pixel, plus any piexels connected 4-directionally to those pixels (also woth the same color),
 * and so on. Replace the color of all the aformentioned pixels with color.
 * 
 * Time Complexity = O(m*n)
 */

public class E_Flood_Fill_Algorithm {
    // ---> Flood Fill.
    public static void floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];

        // Call Helper function.
        helper(image, sr, sc, color, vis, image[sr][sc]);
    }

    // ---> Helper function of FloodFil.
    public static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orignalColor) {

        // base case
        if(sr < 0 || sc < 0 || sr >= image.length ||
            sc >= image[0].length || vis[sr][sc] ||
            image[sr][sc] != orignalColor) {
                
                return;

        }

        vis[sr][sc] = true;

        // Left
        helper(image, sr, sc-1, color, vis, orignalColor);

        // Right
        helper(image, sr, sc+1, color, vis, orignalColor);
        
        // Up
        helper(image, sr-1, sc, color, vis, orignalColor);
        
        // Down
        helper(image, sr+1, sc, color, vis, orignalColor);
    }
    
    
    public static void main(String[] args) {
        int[][] image = { {1, 1, 1},
                          {1, 1, 0},
                          {1, 0, 1} };

        floodFill(image, 1, 1, 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
