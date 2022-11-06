/* (Microsoft, Facebook, Paytm, Snapdeal, OYO)
 * 
 * Question: 8: Max Area in Histogram. (HARD QUESTION) ---> Time Complexity: O(n)
 * 
 * Given an Array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * Return the area of the Largest Rectangle in the histogram.
 * 
 * Example:
 * heights = [2,1,5,6,2,3] ---> Ans: 10
 * 
 * Use Next Greater Element Right Approach: (Question no: 5)
 * 
 * Approach:
 * Area = height[i] * Width
 * where, WIDTH find using ---> Next smaller left (i) & ---> Next smaller right (j)
 * width = j-i-1;
 */

import java.util.Stack;

public class K_HistrogramMaxArea {
    // Max Area Histogram
    public static void histogram(int arr[]) { // O(n)
        int nsl[] = new int[arr.length]; // next smaller left
        int nsr[] = new int[arr.length]; // next smaller right
        int maxArea = 0;
        
        // Next smaller right ---> O(n)
        Stack<Integer> s = new Stack<>();
        
        for (int i = arr.length-1; i >= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length; // n
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        
        // Next smaller left ---> O(n)
        s = new Stack<>(); // create empty stack

        for (int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1; // n
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Current Area : width = j - i - 1 = nsr[i] - nsl[i] -1 ---> O(n)
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea,area);
        }

        System.out.println("Maximum Area in histogram: "+ maxArea);
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};

        histogram(heights);
    }
}
