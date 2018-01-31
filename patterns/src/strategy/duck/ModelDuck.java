package strategy.duck;

public class ModelDuck extends Duck {

    public ModelDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Display Model duck");
    }

    @Override
    public void doSomething() {

    }
}
