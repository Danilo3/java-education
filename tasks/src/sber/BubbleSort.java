package sber;

import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(int []array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[i]>array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]array = new int[10];
        Random random = new Random(43);
        array = random.ints(10).toArray();
        System.out.println("Unsorted array:");
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
        bubbleSort(array);
        System.out.println("Sorted array:");
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
