package sber;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTask {
    public static void main(String[] args) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        TreeSet<Integer> integerTreeSet = new TreeSet<>();

        add(integerHashSet);
        add(integerTreeSet);

        System.out.println(integerHashSet.size()+ integerTreeSet.size());

        for (Integer integer:
             integerHashSet) {
            System.out.println(integer);
        }
    }

    public static void add(Set<Integer> integerSet){
        integerSet.add(new Integer(1));
        integerSet.add(new Integer(1));
        integerSet.add(new Integer(2));

    }

}
