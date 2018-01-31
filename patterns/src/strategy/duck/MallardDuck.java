package strategy.duck;

public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("Display strategy.duck.MallardDuck");
    }

    @Override
    public void doSomething() {

    }
}
