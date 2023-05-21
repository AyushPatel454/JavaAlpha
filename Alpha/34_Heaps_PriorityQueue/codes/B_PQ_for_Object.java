/*
 * ===> Priority Queue for Object.
 * 
 * Sort object on basis of it's data member.
 */


import java.util.PriorityQueue;

public class B_PQ_for_Object {
    // Student - Class ----> Implement interface: Comparable
    // Comparable helps to compare all the object of specific Class <Student>
    // compareTo() ---> must be override. In which define ob which basis we want to compare/sort all the Studen class object.
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // compareTo() ---> Must be override. Method of Comparable.
        @Override
        public int compareTo(Student s2) { // compare current objec (this) to all the object of Student class s2.
            return this.rank - s2.rank; // It can return 3 values.
                                        // -ve ---> obj1(this) < s2 ---> (s1 < s2)
                                        // +ve ---> obj1(this) > s2 ---> (s1 > s2)
                                        //  0  ---> obj1(this) = s2 ---> (s1 = s2)
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(); // Ascending order.
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder()); // Descending order.

        pq.add(new Student("A", 4)); // O(log n)
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank); // O(1)
            pq.remove(); // O(log n)
        }
    }
}
