// ===> FLOYD'S Triangel pattern.
// 1 
// 2 3 
// 4 5 6 
// 7 8 9 10
// 11 12 13 14 15


public class fourth_pattern {
    public static void FlyodTriangle(int rows) {
        int num = 1;
        // outsider loop ---> for row
        for (int i = 1; i <= rows; i++) {
            // inner loop ---> printing num
            for (int j = 1; j <= i; j++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        FlyodTriangle(4);
    }
}
