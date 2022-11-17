package errors;

public class Lorry extends Car implements Moveable, Stopable { //не было ключевого слова  implements
    @Override
// не переопределен абстрактный метод класса Car
    void open() {
        System.out.println("Lorry is open");
    }

    @Override
    public void move() {
        System.out.println("Lorry is moving");
    }

    @Override
    public void stop() {
        System.out.println("Lorry is stoping");
    }
}
