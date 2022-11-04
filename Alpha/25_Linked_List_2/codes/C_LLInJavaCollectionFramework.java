/*
 * Create Linked List using JAVA COLLECTION FRAMEWORK (JCF)
 */

import java.util.LinkedList; // import LinkedList class

public class C_LLInJavaCollectionFramework {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        // add Last
        ll.addLast(1);
        ll.addLast(2);
        // add First
        ll.addFirst(3);

        System.out.println(ll); // [3,1,2]

        // remove last
        ll.removeLast();
        // remove first
        ll.removeFirst();

        System.out.println(ll); // [1]
        ll.add(13);
        System.out.println(ll.element());
        System.out.println(ll);
        System.out.println(ll.getFirst());
    }
}
