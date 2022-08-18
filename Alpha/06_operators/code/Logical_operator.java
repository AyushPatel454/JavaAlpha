public class Logical_operator {
    public static void main(String[] args) {
        System.out.println("===========&&===========");
        System.out.println("(3>2)&&(9>5): "+((3>2)&&(9>5)));
        System.out.println("(3<2)&&(9>5): "+((3<2)&&(9>5)));
        System.out.println("===========||===========");
        System.out.println("(3>2)||(9>5): "+((3>2)||(9>5)));
        System.out.println("(3<2)||(9>5): "+((3<2)||(9>5)));
        System.out.println("(3<2)||(9<5): "+((3<2)||(9<5)));
        System.out.println("===========!===========");
        System.out.println("!(3>2): "+(!(3>2)));
        System.out.println("!(3<2): "+(!(3<2)));
    }
}
