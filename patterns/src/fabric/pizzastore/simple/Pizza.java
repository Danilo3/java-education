package fabric.pizzastore.simple;

import java.util.ArrayList;

public abstract class Pizza implements fabric.pizzastore.Pizza{
    protected String name;
    protected String dough;
    protected String sauce;

    protected ArrayList<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("Preapring "+ name);
        System.out.println("Tossing " + dough);
        System.out.println("Adding sauce "+ sauce);
        for (String topping:
             toppings) {
            System.out.println("  "+ topping);
        }
    }

    public void bake() {
        System.out.println("Baking");
    }

    public void cut() {
        System.out.println("cut abstract");
    }

    public void box() {
        System.out.println("boxing in modern box");
    }

    public String getName() {
        return name;
    }
}
