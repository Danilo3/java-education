package fabric.pizzastore.abstrct;

public class CheesePizza extends Pizza {
    PizzaIngredientFactory factory;
    public CheesePizza(PizzaIngredientFactory factory){
        this.factory = factory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing "+ name);
        dough = factory.createDough(); // fabric method
        sauce = factory.createSauce();
        cheese = factory.createCheese();
    }
}
