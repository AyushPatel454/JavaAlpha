/*
 * Question no: 4: First non-repeating letter in a stream of characters. (String is given)
 * Company: Flipkart
 * 
 * Time Complexity: O(n)
 * Hint: Stream of charachter all question are solve using queue.
 * 
 * Example:
 *    str = a  a b c c x b
 * result = a -1 b b b b x
 *      Explanation:
 *          Stream          First Non-Repeating
 *          a                       a
 *          aa                     -1
 *          aab                     b
 *          aabc                    b
 *          aabcc                   b
 *          aabccx                  b
 *          aabccxb                 x
 * 
 * Step: 1: Create Frequency array 26 size. For store the repetion of each character. 'a' to 'z'
 * Step: 2: Create Queue Charachter type. ---> For finding 1st Non-Repeating character. (store character.)
 * Step: 3: LOOP: 0 to str.length()
 *          Step: 1: store the ith character in varible of char.
 *          Step: 2: add ch in queue.
 *          Step: 3: increment frequecy for particular char. ---> freq[ch-'a']++
 *          Step: 4: WHILE: IF(queue is not Empty && frontOfQueueChar Frequecy > 1) ---> Remove Front.
 *          Step: 5: IF(queue is empty) ---> PRINT -1
 *                   ELSE ---> PRINT front of Queue (which is 1st Non-Repeating charachter for that stream.) 
 */

import java.util.*;

public class G_PrintFirstNonRepeating {

    // 1st Non-Repeating character for stream.
    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; // 'a' to 'z' ---> Tracking the frequecy of each latter.
        Queue<Character> q = new LinkedList<>(); // store the stream charachter.

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty()) { // if no element in queue (means no Non-Repating character for that stream.)
                System.out.print(-1+" "); // print -1
            } else { // queue is not empty means Non-Repating element is present for that particular stream.
                System.out.print(q.peek()+" "); // peek ---> Front. (1st Non-Repeating character.)
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";

        printNonRepeating(str);
    }
}
