package fabric.pizzastore.abstrct;

public abstract class Pizza  implements fabric.pizzastore.Pizza{
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;

    abstract public void prepare();

   public void bake(){
        System.out.println("Baking abstract");
    }
    public void cut(){
        System.out.println("Cut abstract");
    }
    public void box(){
        System.out.println("Boxing abstract");
    }

    public void setName(String name) {
        this.name = name;
    }
    String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name+ cheese+ dough + sauce;
    }
}
