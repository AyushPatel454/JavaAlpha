/* *MIMP* *MIMP* *MIMP* *MIMP* *MIMP* *MIMP* *MIMP* *MIMP* *MIMP* *MIMP*
 * ===> Question: 5: Chocola Problem
 * (Microsoft, Google, Amazon, Facebook)
 * 
 * We are given a bar of chocolate composed of (m x n) square pieces. One should break the chocolate into single square.
 * Each break of part of chocolate is charged a cost express by positive Integer.
 * This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along.
 * Let us denote the costs of breaking along consecuitve verticle lines with x1, x2, ... , xm-1 & along horizontal line with y1, y2, ... ,yn-1.
 * 
 * Compute the minimal cost of breaking the whole chocolate into single square.
 * 
 * ---> For deeply understandind question and answer reffer notes. (Note - 2)
 */

import java.util.*;

public class H_ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; // m-1 = 6 - 1 = 5
        Integer costHor[] = {4, 1, 2}; // n-1 = 4 - 1 = 3

        // Sort Vertical & Horizontal Cost in Descending order.
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // For traverse costHor & costVer
        int hp = 1, vp = 1; // Initially Horizontal Piece = Vertical Piece = 1 
        int cost = 0; // for answer.

        while(h < costHor.length && v < costVer.length) {
            if(costVer[v] <= costHor[h]) { // Horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        // If Horizontal cut (Array) is remaning.
        while(h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        // If Vertical cut (Array) is remaing.
        while(v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        // Printing minimum cost to get single square of chocolate.
        System.out.println("Minimum cost of cuts = "+cost);
    }
}
