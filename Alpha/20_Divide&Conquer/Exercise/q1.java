/*
 * Question 1 : Apply Merge sort to sort an array of Strings. (Assume that all the characters in
 * all the Strings are in lowercase). (EASY)
 * 
 * Sample Input 1 : arr = { "sun", "earth", "mars", "mercury" }
 * Sample Output 1 : arr = { "earth", "mars", "mercury", "sun"}
 */

public class q1 {
    // merge sort
    public static void mergeSort(String arr[],int si,int ei) {
        // base case
        if(si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei-si)/2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr,si,mid,ei);
    }
    // merge
    public static void merge(String arr[],int si,int mid,int ei) {
        // kaam
        // 0,1 ---> 1 - 0 + 1 = 2 ; 2,4 ---> 4 - 2 + 1 = 3
        String temp[] = new String[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i<= mid && j<=ei) {
            // str1.compareto(str2) ---> Return 0 ---> Thats means both string are equal
            // str1.compareto(str2) ---> Return 1 ---> Thats means str1 > str2 ("ab">"aa") str1 = ab & str2 = aa
            // str1.compareto(str2) ---> Return -1 ---> Thats means str1 < str2 ("aa"<"ab") str1 = aa & str2 = ab
            if(arr[i].compareTo(arr[j]) < arr[j].compareTo(arr[i])) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // left side remaning the
        while (i<=mid) {
            temp[k] = arr[i];
            k++;
            i++; 
        }
        // right side element is remaing then
        while (j<=ei) {
            temp[k] =arr[j];
            k++;
            j++; 
        }

        // copy element into arr (main array)
        for (k = 0,i = si; k < temp.length; k++,i++) {
            arr[i] = temp[k];
        }
    }

    // Display Array
    public static void display(String arr[]) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.print(" }");
        System.out.println();
    }

    public static void main(String[] args) {
        // String str1 = "aa";
        // String str2 = "ab";
        //          -1             <          1
        // if(str1.compareTo(str2) < str2.compareTo(str1)) {
        //     System.out.println(str1);
        // }
        // else {
        //     System.out.println(str2);
        // }
        String arr[] = {"sun","earth","mars","mercury","sun"};
        System.out.println("Before sorting:");
        display(arr);
        mergeSort(arr, 0, arr.length-1);
        System.out.println("After sorting:");
        display(arr);
    }
}
