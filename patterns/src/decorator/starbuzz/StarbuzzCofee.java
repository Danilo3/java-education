package decorator.starbuzz;

/*
Декоратор - динамически наделяет обьект новыми возможностями и является гибкой альтернативой субклассированию
            в области расширения функциональности
 */
public class StarbuzzCofee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage);

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);

        System.out.println(beverage1);


    }
}
