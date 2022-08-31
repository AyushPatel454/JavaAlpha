public class N_MultiLevelInheritanceUsingInterface {
    public static void main(String[] args) {
        Child ch1 = new Child();
        ch1.house();
        ch1.cook();
    }
}

interface Dad {
    void house();
}

interface Mom {
    void cook();
}

class Child implements Dad,Mom {
    public void house() {
        System.out.println("DAD house is access by chiild.");
    }

    public void cook() {
        System.out.println("MOM cook's food and Child can access.");
    }
}