import java.util.Scanner;

public class area_circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float radius , area;
        
        System.out.println("Enter radius: ");
        radius = sc.nextFloat();
        
        // 3.14 is double value in java. So convert into in float
        // 3.14f ---> now is float value.
        // any decimal value is by default double data type.
        area = 3.14f*radius*radius; // without f it gave error.

        System.out.println(area);
    }
}
