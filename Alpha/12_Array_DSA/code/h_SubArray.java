// print subarray of array.

public class h_SubArray {
    public static void subArray(int arr[]) {
        int count = 0; // coount total sub array.
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]); // num print
                }
                count++;
                System.out.print(" "); // space print
            }
            System.out.println(); // next line print
        }
        System.out.println("Total sub array: "+count);
    }

    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};

        subArray(arr);
    }
}
