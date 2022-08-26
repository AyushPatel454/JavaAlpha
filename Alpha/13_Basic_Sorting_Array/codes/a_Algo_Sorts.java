// import java.lang.reflect.Array;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class a_Algo_Sorts {
    //bubble sort
    public static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length-1; turn++) {
            for (int j = 0; j < arr.length-1-turn; j++) {
                if(arr[j]>arr[j+1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // selection sort
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for(int j = i+1; j<arr.length; j++) {
                if(arr[minPos]>arr[j]) {
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    // insertion sort
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int previous = i - 1;

            //finding out the correct position to insert
            while(previous>=0 && arr[previous] > arr[current]) {
                arr[previous+1] = arr[previous];
                previous--;
            }

            //insertion
            arr[previous+1] = current;
        }
    }

    public static int compare(int a,int b) {
        // a < b -ve
        // a == b 0
        // a > b +ve
        return b-a;
    }

    // counting sort
    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest,arr[i]);
        }

        int count[] = new int[largest+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        //sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {5,4,1,3,2};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        
        // ===> Inbuilt sorting.
        Arrays.sort(arr);
        // ===> Inbuilt sorting.
        Arrays.sort(arr,0,3);
        printArr(arr);
        
        // ===> Inbuilt sorting. using collection library
        Integer arr2[] = {5,4,1,3,2};
        Arrays.sort(arr2,0,3,Collections.reverseOrder());

        int countingsort[] = {1,4,1,3,2,4,3,7};
        countingSort(countingsort);
        printArr(countingsort);





    }
}