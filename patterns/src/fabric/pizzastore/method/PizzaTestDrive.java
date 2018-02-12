package fabric.pizzastore.method;



/*
Фабричный метод - определяет интерфейс создания обьекта, но позволяет выбрать класс создаваемого экземпляра
                    Делегирует операцию создания экземпляра субклассам
 */

import fabric.pizzastore.Pizza;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println(pizza);

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println(pizza);

    }
}
