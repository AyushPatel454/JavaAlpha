/*
* Question: 2: Find if any pair in a Sorted ArrayList has a target sum.
* 
* list: [1,2,3,4,5,6] target = 5 (*List must be in sorted form)
*/

/*
* ===> Brute force Approach - O(n^2)
*/

import java.util.ArrayList;

public class J_PairSum1 {
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
    public static boolean pairSumOptimize(ArrayList<Integer> list,int lp,int rp,int target) {
        while(lp<rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target) {
                lp++;
            }
            else {
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;

        System.out.println(target+" in list? = "+pairSum(list, target) + " (Using Brue force Approach)");
        System.out.println(target+" in list? = "+pairSumOptimize(list, 0, list.size()-1,target) + " (Using 2 Pointer Approach)");
    }
}
