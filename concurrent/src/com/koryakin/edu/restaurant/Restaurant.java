package com.koryakin.edu.restaurant;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant {

    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    final WaitPerson waitPerson = new WaitPerson(this);
    final Chef chef = new Chef(this);
    public Restaurant(){
        executorService.execute(chef);
        executorService.execute(waitPerson);
    }
}

class Meal {
    private final int orderNum;

    public Meal(int orderNum){
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal "+ orderNum;
    }
}



class WaitPerson implements Runnable{

    private Restaurant restaurant;

    public WaitPerson(Restaurant r){
        this.restaurant = r;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restaurant.meal == null){
                        wait();
                    }
                    System.out.println("Waitperson got "+ restaurant.meal);
                    synchronized (restaurant.chef){
                        restaurant.meal = null;
                        restaurant.chef.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Wait Person Interrupted");
        }
    }
}

class Chef implements Runnable{

    private Restaurant restaurant;
    private int count;

    public Chef(Restaurant r){
        this.restaurant =r;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restaurant.meal != null){
                        wait();
                    }
                    if(++count ==10){
                        System.out.println("Out of food closing");
                        restaurant.executorService.shutdownNow();
                    }
                    System.out.println("Order up! ");
                    synchronized (restaurant.waitPerson){
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.notifyAll();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}