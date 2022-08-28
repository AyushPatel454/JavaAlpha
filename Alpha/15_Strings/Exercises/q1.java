import java.util.Scanner;

/*
 * Question: 1: Count how many times lowecase vowels occured in a Stirng 
 * entered by the user.
 * VOWELS ---> a,e,i,o,u
 */

 public class q1 {
    public static int answer(String str) {
        int count = 0;
        int lenght = str.length();
        for (int i = 0; i < lenght; i++) {
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = answer(str);
        System.out.println("Total vowels are: "+count);
    } 
 }