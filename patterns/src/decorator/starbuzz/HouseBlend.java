package decorator.starbuzz;

public class HouseBlend extends Beverage {

    public HouseBlend(){
        this.description ="House blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
