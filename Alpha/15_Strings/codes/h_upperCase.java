/* (Company: Code Nation)
 * Question: 4: For a give string convert each the first
 * letter of each word to uppercase.
 * Example:
 * "hi, we are amysh." ---> "Hi, We Are Amysh."
 */
/*
 * Time Complexity: O(n);
 */
public class h_upperCase {
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        // 0th index always capital.
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        System.out.println(ch);

        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "hi, we are amysh.";
        System.out.println(toUpperCase(str));
    }
}
