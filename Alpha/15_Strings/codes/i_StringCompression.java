/* (Company: Amazon)
 * Question: 5: String Compression.
 * Example:
 * "aaaabbbdd" ---> "a4b3d2"
 * "aaabbcccdd" ---> "a3b2c3d2"
 * "abc" ---> "abc" is correct. , "a1b1c1" not correct. (is not compression.)
 */
/*
 * TimeComplexity: O(n);
 */

public class i_StringCompression { // TimeComplexity: O(n);

    // public static String stringCompression(String str) {
    //     StringBuilder sb = new StringBuilder("");
    //     Integer count = 1; // Integer use for convert in String.

    //     for (int i = 1; i < str.length(); i++) {
    //         if(str.charAt(i) == str.charAt(i-1)) {
    //             count++;
    //         }
    //         else {
    //             sb.append(str.charAt(i-1));
    //             if(count > 1) {
    //                 sb.append(count);
    //             }
    //             count = 1;
    //         }
    //         if(i == str.length()-1) {
    //             sb.append(str.charAt(i));
    //             if(count > 1) {
    //                 sb.append(count);
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }

    // ===> Apna college method.
    public static String compress(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            Integer  count = 1; // for convert Integer value to string. int not use because it's not a class.
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1) {
                newStr += count.toString(); // convert Integer to String.
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        String str = "aaaabbbdd";
        // String str = "abcd";
        // System.out.println(stringCompression(str));
        System.out.println(compress(str));
    }
}
