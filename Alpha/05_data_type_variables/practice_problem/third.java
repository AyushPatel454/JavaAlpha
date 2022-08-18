// Enter cost of 3 items from the user (using float datatype)- a pencil,a pen and an eraser.
// You have to output the total cost of the items back to the user as their bill.
// (Add on : You can also try adding 18% gst tax to the items in the bill as an advanced problem.
import java.util.*;

public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();
        float GST = ((pencil + pen +eraser)*18)/100;
        float cost = pencil + pen + eraser + GST;
        System.out.println("your cost is: "+ cost);        
    }
}
