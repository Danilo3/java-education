package croc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*

Перед началом летнего сезона известное туристическое агенство решило назначить звёздность n отелям, то есть каждому отелю должно быть
присвоено определенное количество звёзд — от 1 до 5. Про каждый отель известен его рейтинг — целое число от 1 до 100. Все рейтинги различны.

После присвоения всем отелям звёздности для любых двух отелей должно выполняться следующее свойство — если рейтинг отеля A больше
чем рейтинг отеля B, то количество звёзд, присвоенное отелю A, должно быть не меньше, чем количество звёзд, присвоенное отелю B.

Перед вами стоит задача назначить количество звёзд каждому отелю таким образом, чтобы выполнилось описанное выше свойство,
а также, чтобы отелей каждой звёздности было поровну. Гарантируется, что n кратно пяти.

Входные данные

В первой строке следует целое положительное число n (5 ≤ n ≤ 100) — количество отелей, n кратно 5.

Во второй строке следует последовательность из n различных целых положительных чисел a1, a2, ..., an (1 ≤ ai ≤ 100),
где ai равно рейтингу i-го отеля.

Выходные данные

Выведите n целых чисел от 1 до 5, где i-е число должно быть равно звёздности i-го отеля.

Примеры

Входные данные

5
99 2 100 50 1

Выходные данные

4 2 5 3 1

Входные данные

10
100 90 10 20 50 60 40 30 80 70

Выходные данные

5 5 1 1 3 3 2 2 4 4

Примечание

В первом тестовом примере всего 5 отелей, поэтому отеля каждой звёздности должно быть по одному.
 Очевидно, что 1 звезду нужно присвоить отелю с самым низким рейтингом,
  то есть отелю номер 5 (его рейтинг равен 1). Тогда 2 звезды нужно присвоить отелю с самым низким рейтингом из оставшихся,
   то есть отелю номер 2 (его рейтинг равен 2). Продолжая аналогичным образом, 3 звезды нужно присвоить отелю номер 4 (его рейтинг равен 50),
    4 звезды нужно присвоить отелю номер 1 (его рейтинг равен 99), а 5 звёзд нужно присвоить отелю номер 3 (его рейтинг равен 100).
 */


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arrayInt = new int[n];
        ArrayList<IndexValue> rating = new ArrayList<>(n);
        int[] stars = new int[n];
        for (int i = 0; i <n ; i++) {
            Integer value = scanner.nextInt();
            rating.add(new IndexValue(i,value));
        }

        rating.sort(Comparator.comparingInt(a -> a.v));


        int score =1;
        for (int i = 0; i < n; i++) {
                int index = rating.get(i).i;
                stars[index] = score;
                if (((i+1)%(n/5)==0)){
                    score+=1;
                }
            }
        for (int i = 0; i <n ; i++) {
            System.out.print(stars[i]+" ");
        }
    }
}

class IndexValue {
    final int i,v;

    public IndexValue( int i, int v ) {
        this.i = i;
        this.v = v;
    }
}

