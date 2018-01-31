package strategy.duck;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly(){
        System.out.println("I'am flying with wings");
    }
}
