/*
 * Question: 2: Given a route containing 4 directions (E,W,N,S), find the SHORTEST path to reach destination.
 * "WNEENESENN" ---> Shortest Path is: 5
 */

import java.math.*;

public class c_ShortestPath {
    public static double ShortestPath(String str) {
        int x = 0; // W = x--; E = x++;
        int y = 0; // S = y--; N = y++;
        int n = str.length()-1; // index 0 to length - 1;
        for (int i = 0; i <= n; i++) {
            if(str.charAt(i) == 'W') {
                x--;
            }
            else if(str.charAt(i) == 'E') {
                x++;
            }
            else if(str.charAt(i) == 'N') {
                y++;
            }
            else {
                y--;
            }
        }
        double x2 = Math.pow(x,2);  // x*x
        double y2 = Math.pow(y,2);  // y*y
        double ans = Math.sqrt(x2+y2);
        return ans;
    }
    public static void main(String[] args) {
        String direction= "WNEENESENNN";      
        String direction2= "NS";      
        System.out.println("Shortest path is: "+ShortestPath(direction));
        System.out.println("Shortest path is: "+ShortestPath(direction2));
    }
}
