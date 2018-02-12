package fabric.pizzastore.abstrct;

import fabric.pizzastore.method.PizzaStore;


public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        switch (type){
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("NY style cheese pizza ");
                break;
            default:

        }
        return pizza;
    }
}
