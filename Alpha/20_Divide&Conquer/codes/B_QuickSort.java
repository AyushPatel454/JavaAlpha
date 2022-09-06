public class B_QuickSort {
    // QuickSort
    public static void quickSort(int arr[],int si,int ei) {
        // base case
        if(si >= ei) {
            return;
        }
        // last element (pivot)
        int pidx = partition(arr,si,ei);
        quickSort(arr, si, pidx-1);
        quickSort(arr, pidx+1, ei);
    }

    // Partition
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; // to make placefor elements smallert than pivot

        for (int j = si; j < ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i; // return pivot index number.
    }

    // Print Array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

        int arr2[] = {6,3,9,8,2,5,-2};
        quickSort(arr2, 0, arr2.length-1);
        printArr(arr2);
    }
}
