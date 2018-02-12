package fabric.pizzastore.abstrct;



/*
    Абстрактная фабрика - предоставляет интерфейс создания семейств взаимосвязанных или взаимозависимых обьектов
     без указания их конкретных классов
 */

import fabric.pizzastore.Pizza;
import fabric.pizzastore.method.ChicagoPizzaStore;
import fabric.pizzastore.method.NYPizzaStore;
import fabric.pizzastore.method.PizzaStore;


public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println(pizza);

    }
}
