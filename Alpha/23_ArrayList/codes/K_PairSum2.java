/*
* Question: 3: Find if any pair in a Sorted & Rotated ArrayList has a target sum.
* 
* list: [11,15,6,8,9,10] target = 5 (*List can be in sorted or Sorted&Rotated ArrayList.)
*/

/*
* ===> Brute force Approach - O(n^2)
* ===> 2 Pointer Approach - O(n)
*/

import java.util.ArrayList;

public class K_PairSum2 {
    // Brute force - O(n^2)
    public static boolean pairSum(ArrayList<Integer> list,int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // 2 Pointer Approach - O(n)
    // lp = left pointer , rp = right pointer
    public static boolean pairSumOptimize(ArrayList<Integer> list,int target) {
        int bp = -1; // breaking point
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > list.get(i+1)) {
                // breaking point
                bp = i;
                break;
            }
        }

        int lp = bp + 1; // smallest
        int rp = bp; // largest
        int n = list.size(); // list size

        while(lp != rp) {
            // case 1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            }
            else {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        System.out.println(target+" in list? = "+pairSum(list, target) + " (Using Brue force Approach)");
        System.out.println(target+" in list? = "+pairSumOptimize(list,target) + " (Using 2 Pointer Approach)");
    }
}
