/*
 * Problem: 4: Print sum of first n natural number. (Decreasing Order.)
 */

public class D_SumOfNnumber {
    public static int sumOfNnaturalNum(int n) {
        if(n == 1) {
            return 1;
        }
        int fnm1 = sumOfNnaturalNum(n-1);
        int fn = n + fnm1;
        return fn;
    }
    public static void main(String[] args) {
        System.out.println(sumOfNnaturalNum(5));
    }
}
