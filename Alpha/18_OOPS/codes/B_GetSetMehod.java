// Getter & Setter
//  this.variableName ----> Where, this: is keyword is used to reffer to the current object.

public class B_GetSetMehod {
    public static void main(String[] args) {
        //Creating object of Pen1 class...
        Pen1 p1 = new Pen1();
        p1.setColor("blue");
        System.out.println(p1.getColor());

        p1.setTip(3);
        int n = p1.getTip();
        System.out.println("Tip: "+n);

    }
}

class Pen1 {
    private String color;
    private int tip;

    //set mehod
    public void setColor(String color) {
        this.color = color; // this.color means class's color not function color.
        // This keyword is used to refer to the current object.
    }
    public void setTip(int Tip) {
        this.tip = Tip; // this.tip means class's tip not function tip.
        // This keyword is used to refer to the current object.
    }
    
    //get method
    public String getColor() {
        return this.color;
    }
    public int getTip() {
        return this.tip;
    }
}