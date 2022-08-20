// Function Overloading...
// Calculate sum.

public class overloadin {
    // Function to calculate sum of 2 int nums.
    public static int sum(int a,int b) {
        return a + b;
    }
    // Function to calculate sum of 3 int nums.
    public static int sum(int a,int b,int c) {
        return a + b + c;
    }
    // Function to calculate sum of 2 float nums.
    public static float sum(float a,float b) {
        return a + b;
    }
    
    // Main function.
    public static void main(String[] args) {
        // add 2 int value
        System.out.println(sum(4,5));
        // add 3 int value
        System.out.println(sum(9,5,1));
        // add 2 float value
        System.out.println(sum(19.0f,25.0f));
    }
}
