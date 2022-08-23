// binary search

public class e_BinarySearch {
    public static int binarySearch(int num[],int key) {
        int low = 0;
        int end = num.length;

        while(low <= end) {
            int mid = (low+end)/2;
            if(num[mid] == key) {
                return mid;
            }
            else if(num[mid] > key) {
                end = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1; // if key is not found.
    }

    public static void main(String[] args) {
        int number[] = {1,2,3,4,5,6}; // sorted array.
        int x = 6;

        System.out.println(x+" is found index no: "+binarySearch(number, x));
    }
}
