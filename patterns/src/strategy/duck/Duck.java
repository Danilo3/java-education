package strategy.duck;

public abstract class Duck {

    FlyBehavior flyBehavior; //Отдавать предпочтение композиции перед наследованием. Инкапсуляция изменяющихся вещей

    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }


    public void swim(){
        System.out.println("Swimming");
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public abstract void display();
    public abstract void doSomething();
}
