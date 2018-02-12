package fabric.pizzastore;

public interface Pizza {
    String name = null;
    void prepare();
    void bake();
    void box();
    void cut();
}
