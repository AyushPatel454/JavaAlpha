// ===> Check if a number is PRIME of NOT.
// ===> NOT OPTIMISE METHOD <===

public class PrimeOrNot {
    //only for n>=2
    public static boolean isPrime(int n) {
        // corner cases
        //2
        if(n == 2) {
            return true;
        }
        for (int i = 2; i <= n-1; i++) {
            if(n % i == 0) { // completely dividing.
                // isPrime = false;
                // return isPrime;
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(5));
        System.out.println(isPrime(9));
        System.out.println(isPrime(19));
        System.out.println(isPrime(25));
        System.out.println(isPrime(2));
    }
}
