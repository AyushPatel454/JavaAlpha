public class test2 {
    // subString count
    public static int subString(String str,int n,String newStr){
        int count = 0;

        if(n == str.length()) {
            return count;
        }
        if(newStr == "") {
            count = subString(str, n+1, newStr);
        }

        newStr = newStr + str.charAt(n);
        
        if(newStr.charAt(0) == newStr.charAt( newStr.length() - 1 )) {
            count++;
        }

        count = count + subString(str, n+1, newStr);

        return count;
    }

    public static void main(String[] args) {
        int ans = subString("aaab", 0, "");
        // System.out.println("aba".length()); // 3
        System.out.println(ans);
    }
}
