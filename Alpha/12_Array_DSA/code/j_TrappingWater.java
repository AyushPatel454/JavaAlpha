// ===> Question: Traping Water
// DSA Qs sheet. Question no: 22

import java.util.*;

public class j_TrappingWater {

    public static int TrappingWater(int arr[]) { //Time complexity: O(n)
        int n = arr.length;
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        
        // calculate left max boundary - array
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i],leftMax[i-1]);
        }
        
        // calculate right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i],rightMax[i+1]);            
        }
        
        int trappedWater = 0;
        //loop
        for (int i = 0; i < n; i++) {
            //wathrLevel = min(leftmax boud , rightmax boud)
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            //trapped water = waterLevel - height[i]
            trappedWater += waterLevel - arr[i];
        }

        return trappedWater;
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(TrappingWater(height));
    }
}