

class Automobile {

  private String drive() {
    return "Driving vehicle";
  }
}

class Car extends Automobile {

  protected String drive() {
    return "Driving car";
  }
}

public class q2 extends Car {

  @Override
  public final String drive() {
    return "Driving electric car"; // ans
  }

  public static void main(String[] wheels) {
    final Car car = new q2();
    System.out.print(car.drive());
  }
}
