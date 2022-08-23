// pass array argument (to function with pass by reference)

public class b_passArray_argument {
    public static void updat(int arr[]) {
        // scan array
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
        }
    }
    public static void main(String[] args) {
        int marks[] = {60,70,80};

        // array pass ---> always pass by Referance
        // functions change of array are also reflected in main function.
        updat(marks);
        
        // print array's values.
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]); // 70 , 80 , 90
        }
    }
}
