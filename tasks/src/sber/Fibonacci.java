package sber;

public class Fibonacci {

    public static void fibonacci(int n){
        if(n<=0){
            System.out.println("Not found");
            return;
        }
        if(n==1){
            System.out.println(0);
        }else{
            int prevSum=0; int sum =1; int count =1; int temp=0;
            while(count<n){
                temp = sum;
                sum+=prevSum;
                prevSum =temp;
                count++;
            }
            System.out.println(sum);
        }
    }
    public static long recursiveFibonacci(int n){
        if(n==0) {
            return 0;
        }else if(n==1){
            return 1;
        }
        else{
            return recursiveFibonacci(n-1)+ recursiveFibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println("Non recursive:");
        for (int i = 1; i <10 ; i++) {
            fibonacci(i);
        }
        System.out.println("Recursive:");
        for (int i = 0; i <10 ; i++) {
            System.out.println(recursiveFibonacci(i));
        }


    }
}
