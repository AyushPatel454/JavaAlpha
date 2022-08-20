// ===> Print all Primes in Range

public class PrintAllPrimeRange {
    // Check Prime or not.
    public static boolean isPrime(int n) {
        // corner cases
        //2
        if(n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) { // completely dividing.
                // isPrime = false;
                // return isPrime;
                return false;
            }
        }
        return true;
    }

    // Print PRIME nums in given range n.
    public static void PrimeInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) { // true
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    // Main function.
    public static void main(String[] args) {
        PrimeInRange(100);
    }
}
