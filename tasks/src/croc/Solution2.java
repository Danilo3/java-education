package croc;
/*
В данной задаче почтовый адрес представляет собой строку вида login@domain, где

    login — это непустая строка, состоящая из строчных и прописных букв английского алфавита, точек и знаков плюс, начинающаяся с буквы,
    domain — это непустая последовательность из строчных и прописных букв английского алфавита и точек,
    причем точки разбивают эту последовательность на непустые строки, состоящие только из букв.

При сравнении почтовых адресов регистр букв игнорируется (адреса woRk@woRK.Ru и WORk@work.Ru эквивалентны).

Если домен почтового адреса равен gmail.com для него выполняются еще два правила:

   все точки в login игнорируются (адреса work@gmail.com и w.o.r.k@gmail.com эквивалентны,
   если в login есть один или более знаков плюс, все что следует за самым левым плюсом игнорируется
  (адреса work@gmail.com и work+from+home@gmail.com эквивалентны).

Вам будет заданы n почтовых адресов, требуется разбить их на группы эквивалентных адресов.

Входные данные

В первой строке следует целое положительное число n (1 ≤ n ≤ 2·104) — количество почтовых адресов.

В следующих n строках заданы сами адреса по одному в строке. Гарантируется, что они корректны. Все заданные адреса различны.
Длина почтовых адресов не менее 3 и не более 100 символов.

Выходные данные

В первую строку выведите одно число k — количество групп эквивалентных адресов.

В следующих k строках выведите сами группы по одной группе в строке.
Сначала должно идти целое число — размер текущей группы,
а затем через пробел сами почтовые адреса, которые принадлежат в текущей группе.
Разрешается выводить группы и адреса в каждой группе в произвольном порядке.

Выводите почтовые адреса именно так, как они заданы во входных данных.
Каждый адрес из входных данных должен принадлежать ровно одной группе.

Примеры

Входные данные

6
DEVELOPER.@gmail.com
t+es+ter@GMAIL.COM
T@bmail.com
a@gmail.com.ru
D.eveloper@Gmail.Com
a+b@gmail.com.ru

Выходные данные

5
1 a@gmail.com.ru
1 t+es+ter@GMAIL.COM
2 DEVELOPER.@gmail.com D.eveloper@Gmail.Com
1 a+b@gmail.com.ru
1 T@bmail.com
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {

        ArrayList<String> inputEmails = new ArrayList<>(10);
        int count =0;
        ArrayList<Group> groups = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if(scanner.hasNext()) {
                inputEmails.add(scanner.nextLine());
            }
        }
        scanner.close();


        while(inputEmails.size()>0) {
            String firstEmail = inputEmails.get(0);
            Group group = new Group();
            group.add(firstEmail);
            for (int j = 1; j <inputEmails.size() ; j++) {
                String secondEmail = inputEmails.get(j);
                if(matches(firstEmail, secondEmail)){
                    group.add(secondEmail);
                    inputEmails.remove(secondEmail);
                }
            }
            inputEmails.remove(firstEmail);
            groups.add(group);
        }

        System.out.println(groups.size());
        for (Group group : groups) {
            System.out.println(group);
        }
    }



    public static boolean matches(String firstEmail, String secondEmail){

        String lowerFirstEmail = firstEmail.toLowerCase();
        String lowerSecondEmail = secondEmail.toLowerCase();

        if(lowerFirstEmail.equals(lowerSecondEmail)){
            return true;
        }else if(lowerFirstEmail.endsWith("@gmail.com")&&lowerSecondEmail.endsWith("@gmail.com")) {

            String firstLogin = lowerFirstEmail.toLowerCase().replaceFirst("[@].+", "");
            String secondLogin = lowerSecondEmail.toLowerCase().replaceFirst("[@].+", "");

            firstLogin = firstLogin.replaceAll("[.]", "");
            secondLogin = secondLogin.replaceAll("[.]", "");

            if(firstLogin.contains("+")){
                firstLogin.replaceFirst("[+]*", "");
            }
            if(secondLogin.contains("+")){
                secondLogin.replaceFirst("[+]*", "");
            }
            return secondLogin.equals(firstLogin);
        }else{
            return false;
        }
    }

}
class Group {
    private ArrayList<String> emails;

    public Group() {
        this.emails = new ArrayList<>();
    }
    public void add(String email){
        emails.add(email);
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder(Integer.toString(emails.size()) + " ");
        for (String email : emails) {
            str.append(email).append(" ");
        }
        return str.toString();
    }
}


