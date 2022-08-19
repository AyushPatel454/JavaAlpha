// ===> While_Loop

// Print "Hellw World!" 10 times.
public class while_loop {
    public static void main(String[] args) {
        int counter = 0;

        while (counter<10) {
            System.out.println("Hello World!");
            counter++; // ++counter // counter += 1 // counter = counter + 1
        }

        System.out.println("Printed hello world 10 times...");

        /*
        ===> INFINITE LOOP (Never stop untill memory is full...)
            while(true) {
                System.out.println("hello");
            }
         */
    }
}
