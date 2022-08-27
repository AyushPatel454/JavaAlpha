public class d_Comparision {
    public static void main(String[] args) {
        String s1 = "Tony";
        String s2 = "Tony";
        String s3 = new String("Tony");

        if(s1 == s2) {
            // At object level same. (Memory address same because value is same.)
            System.out.println("s1 & s2 are same."); // true
        }
        else {
            System.out.println("s1 & s2 are not same.");
        }
        
        if(s1 == s3) {
            System.out.println("s1 & s3 are same.");
        }
        else {
            // At object level NOT same. (Memory address are different.)
            System.out.println("s1 & s3 are not same."); // true
        }

        if(s1.equals(s3)) {
            // At object level NOT same. But both object value is same.
            System.out.println("s1 & s3 are same. Using .equal()"); // true
        }
        else {
            System.out.println("s1 & s3 are not same. Using .equal()");
        }
    }
}
