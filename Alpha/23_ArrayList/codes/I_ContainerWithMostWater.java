/*
 * Question: 1: Contaier with Most Water.
 * For given n lines on x-axis, use 2 lines to from a container
 * such that it holds maximum water.
 *
 * height: [1,8,6,2,5,4,8,3,7]
 */

/*
  * ===> 2 Pointer Approach - O(n)
  Using loop & Recursive function
  */
import java.util.ArrayList;

public class I_ContainerWithMostWater {

  // Most Water
  static int max = Integer.MIN_VALUE; // (-Infinity)

  // calculate maximum water
  public static void mostWater(ArrayList<Integer> list, int left, int right) {
    // base case
    if (left > right) {
      return;
    }

    // kaam
    int width = right - left;
    int height = Math.min(list.get(left), list.get(right));
    int area = height * width;
    // if(max <= area) {
    //     max = area;
    // }
    max = Math.max(max, area);

    if (list.get(left) < list.get(right)) {
      left++;
    } else {
      right--;
    }
    mostWater(list, left, right);
    //   return;
  }

  // 2 Pointer Approach ===> Apna college method
  public static int loopMostWater(ArrayList<Integer> height) {
    int maxWater = 0;
    int left = 0; // starting index
    int right = height.size() - 1; // last index

    while (left < right) {
      int width = right - left;
      int ht = Math.min(height.get(left), height.get(right));
      int area = ht * width;

      maxWater = Math.max(maxWater, area);

      if (height.get(left) < height.get(right)) {
        left++;
      } else {
        right--;
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

    mostWater(height, 0, height.size() - 1);

    System.out.println("Using recusive method\tMost Wate are = " + max);
    System.out.println(
      "Using Loop mthod\tMost Wate are = " + loopMostWater(height)
    );
  }
}
