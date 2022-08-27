/*
 * ===> String Builder
 */

public class g_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a'; ch <= 'z';ch++) { // Time complexity: O(26)
            sb.append(ch); // add ch at last of sb.
        } // abcdefghijklmnopqrstuvwxyz

        System.out.println(sb);
        System.out.println(sb.length());
    }
}
