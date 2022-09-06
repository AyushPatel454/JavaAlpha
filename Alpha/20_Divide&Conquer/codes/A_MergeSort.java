public class A_MergeSort {
    // merge sort
    public static void mergeSort(int arr[],int si,int ei) {
        // base case
        if(si>=ei) {
            return;
        }

        // kaam
        int mid = si + (ei-si)/2; // mid = (si + ei)/2
        mergeSort(arr, si, mid);   //  left part 
        mergeSort(arr, mid+1, ei); //  right part

        merge(arr,si,mid,ei);
    }

    // merge
    public static void merge(int arr[],int si,int mid,int ei) {
        // (0,2) = 3 element , (3,4) = 2 element; ===> [ei - si + 1] = [4 - 0 + 1] = [5]
        int temp[] = new int[ei-si+1];
        int i = si;  // iteration for left part
        int j = mid + 1; // iteration for right part
        int k = 0; // iteration for temp arr

        while(i<=mid && j<=ei) {
            if(arr[i]<arr[j]) {
                temp[k] = arr[i];
                i++; /* k++; */
            }
            else {
                temp[k] = arr[j];
                j++; /* k++; */
            }
            k++;
        }

        // left
        while(i<=mid){
            temp[k++] = arr[i++];
            // k++ means k ni value je che e rese ena pachhi change thay ne k+1 thse.
        }

        // right
        while(j<=ei){
            temp[k++] = arr[j++];
            // k++ means k ni value je che e rese ena pachhi change thay ne k+1 thse.
        }

        // copy temp to orignal array.
        for (k = 0,i = si; k < temp.length; k++,i++) {
            arr[i] = temp[k];
        }
    }

    // Print Array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
        
        int arr2[] = {6,3,9,5,2,8,-2};
        mergeSort(arr2, 0, arr2.length-1);
        printArr(arr2);
    }
}