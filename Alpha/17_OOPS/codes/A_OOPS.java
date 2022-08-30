public class A_OOPS {
    public static void main(String[] args) {
        // creating object
        // ClassName obj = new ClassName();
        Pen objPen = new Pen();
        
        // acces the attributes and mehods of class.
        objPen.color = "blue";
        objPen.setTip(5);

        // print the value of attributes
        System.out.println(objPen.color); // blue
        System.out.println(objPen.tip);   // 5

        // Bank accound password
        BankAccount myAcc = new BankAccount();
        myAcc.name = "Shraddha";
        // myAcc.password = "abc"; // This give error because our password is not visible in main. Our password is private.
        // set the password using setPassword()
        myAcc.setPassword("abcd");
        System.out.println("Name of Account member: "+myAcc.name);
    }
}

// Class
/*
 * class name always start with capital letter
 * class is created after public class , main method.
 */
class Pen {
    // attribute
    String color;
    int tip;

    // mehods
    void setColor(String clr) {
        color = clr; // set the value of color
    }
    void setTip(int tp) {
        tip = tp; // set the value of tip
    }
}

class BankAccount {
    public String name;
    private String password; // our password is private. we can't acces it at out side class.

    public void setPassword(String pwd) { // we can set the password usig setPassword method. 
        password = pwd;           // (In main fuction we can't set directly: obj.password = 'abc')
    }
}