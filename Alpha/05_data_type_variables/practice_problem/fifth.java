/*
Question 5:(Advanced)Will the following statementgive any error in Java?
int$=24;
Note-These questions are only to help you practice the concepts of this chapter.
These are not designed to test your mathematical skills, just to understand logic building using Java.
*/

public class fifth {
    public static void main(String[] args) {
        int $ = 24;
        System.out.println($); // 24 [NO-ERROR.]

        // In java we can use symbol $ and _ (in other lang we can only use _)
        // but condition for _ is only _ is giving error
        // ex: int _ = 24 ===> ERROR
        // ex: int _name = 24 ===> no-ERROR
    }
}
