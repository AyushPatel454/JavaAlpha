// ===> Block Scope

public class BlockScope {
    // ---> Example 1
    // public static void main(String[] args) {
    //     int p = 59;
    //     {
    //         int s = 95;
    //         System.out.println(p); // p ne access kari sakay 
    //         // Cuse p e function scope ma che & apno block pan same function ma j che.
    //     }
    //     sout(s); // (ERROR) s cannot be resolved to a variable.
    //     // s ne block ni bahar access nathi kari sakta.
    // }

    // ---> Example 2
    // public static void main(String[] args) {
    //     for (int i = 0 ; i <= 3 ; i++) {
    //         System.out.println(i);
    //     }
    //     System.out.println(i); // (ERROR) i cannot be resolved to a variable
    // }
}
