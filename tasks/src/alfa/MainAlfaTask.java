package alfa;//Task:

//Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом. Нужно преобразовать строку в такую структуру данных,
// которая группирует слова по первой букве в слове.
//Затем вывести только группы, содержащие более одного элемента. Группы должны быть отсортированы в алфавитном порядке по всем буквам в слове.
// Слова внутри группы нужно сортировать по убыванию (по количеству символов); если число символов равное, то сортировать в алфавитном порядке.
// Пример строки: String s = "сапог сарай арбуз болт бокс биржа"
// Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]


/*
    Ход решения:
    1) нужна струткра данных для сортировке по букве - отлично подойдет TreeMap
    2) пишем простенький класс, в качестве хранения список слов - ArrayList
    3)Берем строку, превращаем ее в массив разделяя слова по пробелам, добавляем в созданную струтуру данных
    4)Сортируем слова стандартным компаратором для string
    5)при выводе делаем проверку на количество элементов в списке
 */

import java.util.*;

public class MainAlfaTask {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String words = scanner.nextLine();
//        scanner.close();

        String words = "сапог сарай арбуз болт бокс биржа";

        SortedGroups sortedGroups = new SortedGroups();
            for (String word:
                 words.split(" ")) {
                sortedGroups.add(word);
            }
        System.out.println(sortedGroups);
    }
}

class SortedGroups {

    private TreeMap<Character, ArrayList<String>> groups;

    SortedGroups(){
        groups = new TreeMap<>();
    }

    void add(String word){
       Character firstLetter = word.charAt(0);
       if(groups.containsKey(firstLetter)){
           ArrayList<String> list= groups.get(firstLetter);
           list.add(word);
           list.sort(String::compareToIgnoreCase);
       }else {
           groups.put(firstLetter, new ArrayList<>(Arrays.asList(word)) );
       }
    }


    @Override
    public String toString() {
        Iterator<Map.Entry<Character, ArrayList<String>>> entryIterator = groups.entrySet().iterator();
        if (!entryIterator.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            Map.Entry<Character, ArrayList<String>> next = entryIterator.next();
            Character key = next.getKey();
            ArrayList list = next.getValue();
            if (list.size() != 1) {
                sb.append(key);
                sb.append('=');
                sb.append(list);
                if (!entryIterator.hasNext())
                    return sb.append(']').toString();
                sb.append(',').append(' ');
            }
        }
    }
}