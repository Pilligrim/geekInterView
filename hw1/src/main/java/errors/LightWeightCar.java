package errors;

public class LightWeightCar extends Car implements Moveable, Stopable {// Добавлен модификатор  public

    // странно что авто не умеет останавливаться
    @Override
    void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stoping");
    }
}
