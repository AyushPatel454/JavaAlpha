/*
* Question: 1: Contaier with Most Water.
* For given n lines on x-axis, use 2 lines to from a container
* such that it holds maximum water.
* 
* height: [1,8,6,2,5,4,8,3,7]
*/

/*
  * ===> Brute force Approach - O(n^2)
  Using loop & Recursive function
  */
import java.util.ArrayList;
  
public class H_ContainerWithMostWater {
    // Most Water
    static int max = Integer.MIN_VALUE; // (-Infinity)

    // calculate maximum water
    public static void mostWater(ArrayList<Integer> list,int i,int j) {
        // base case
        if(i==list.size() && j==list.size()) {
            return;
        }
        if(j == list.size()) {
            j = i+1;
            mostWater(list, i+1, j);
            return;
        }

        // kaam
        int width = j - i;
        int height = Math.min(list.get(i),list.get(j));
        int area = height * width;
        // if(max <= area) {
        //     max = area;
        // }
        max = Math.max(max, area);
        mostWater(list, i, j+1);
        return;
    }

    // loop method to find most water
    public static int loopMostWater(ArrayList<Integer> height) {
        // brute force
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = ht* width;
                maxWater = Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        mostWater(height, 0, 0);
        
        System.out.println("Using recusive method\tMost Wate are = "+max);
        System.out.println("Using Loop mthod\tMost Wate are = "+loopMostWater(height));
    }
}
