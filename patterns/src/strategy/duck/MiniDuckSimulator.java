package strategy.duck;



/* Стратегия - определяет семейство алгоритмов инкапсулирует и обеспечивает их взаимозаменяемость.
   Паттерн позволяет модифицировать алгоритмы независимо от их использования на стороне клиента
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck(); //Программирование на уровне интерфейсов а не реализации
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered()); //Динамическое измененине алгоритма независмо от клиента
        model.performFly();

    }
}
