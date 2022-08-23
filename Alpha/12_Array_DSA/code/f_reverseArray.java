// reverse array.

public class f_reverseArray {
    public static void reverse(int num[]) {
        int first = 0 , last = num.length-1;

        while(first < last ) {
            // swap
            int temp = num[first];
            num[first] = num[last];
            num[last] = temp;

            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int number[] = {1,2,6,3,5};

        reverse(number);

        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]+" ");
        }
    }
}
