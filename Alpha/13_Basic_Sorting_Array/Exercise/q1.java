/*
Question: Use following sorting algorithm to sort an array in DESCENDING order:
a. Bubble Sort
b. Selection Sort
c. Insertion Sort
d. Counting Sort

You can use this array as example: [3,6,2,1,8,7,4,5,3]
*/

public class q1 {
    // bubble sort:
    public static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // selection sort
    public static void SelectionSort(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minPos]>arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    // insertion sort
    public static void InsertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j-1>=0) {
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                j--;
            }
        }
    }

    // counting sort
    public static void CountingSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int count[] = new int[max+1];
        for (int i = 0; i < count.length; i++) {
            // by default arr[i] = 0 if we not pass value.
            count[arr[i]]++;
        }

        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    // display
    public static void Display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3};
        System.out.println("Bubble Sort:");
        BubbleSort(arr);
        Display(arr);
        
        int arr2[] = {3,6,2,1,8,7,4,5,3};
        System.out.println("Selection Sort:");
        SelectionSort(arr2);
        Display(arr2);
        
        int arr3[] = {3,6,2,1,8,7,4,5,3};
        System.out.println("Insertion Sort:");
        InsertionSort(arr3);
        Display(arr3);
        
        int arr4[] = {3,6,2,1,8,7,4,5,3};
        System.out.println("Counting Sort:");
        InsertionSort(arr4);
        Display(arr4);
    }
}