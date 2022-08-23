// make pair of array's number.

public class g_Pairs {
    public static void printPairs(int numbers[]) {
        int tp = 0;
        for (int i = 0; i < numbers.length; i++) {
            // int current = numbers[i]; // 2, 4, 6, 8, 10
            for (int j = i+1; j < numbers.length; j++) {
                System.out.print("("+numbers[i]+","+numbers[j]+") ");
                tp++;
            }
            System.out.println(); //next line
        }
        System.out.println("Total Pairs: "+tp);
    }

    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10};

        printPairs(numbers);
     }
}
