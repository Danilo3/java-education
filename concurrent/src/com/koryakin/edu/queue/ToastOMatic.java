package com.koryakin.edu.queue;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Butterer(dryQueue, butteredQueue));
        executorService.execute(new Jammer(butteredQueue, finishedQueue));
        executorService.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Toast{
    public enum Status{DRY, BUTTERED, JAMMED}
    private Status status = Status.DRY;

    private final int id;

    public Toast(int idn){
        this.id = idn;
    }
    public void butter(){
        status = Status.BUTTERED;
    }
    public void jam(){
        status= Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast "+ id +": "+ status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> { }

class Toaster implements Runnable{

    private ToastQueue toastQueue;
    private int count =0;
    private Random random = new Random(47);

    public Toaster(ToastQueue tq){
        this.toastQueue = tq;
    }
    @Override
    public void run() {
        try {
             while (!Thread.interrupted()) {
                 TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
             System.out.println("Toaste interrupted");
        }
        System.out.println("Toaster off");
    }
}

class Butterer implements Runnable{

    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Buttered interrupted");
        }
        System.out.println("Buttered off");
    }
}


class Jammer implements Runnable{

    private ToastQueue finishedQueue, butteredQueue;

    public Jammer( ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                Toast toast = butteredQueue.take();
                toast.jam();
                System.out.println(toast);
                finishedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}

class Eater implements Runnable{
    private ToastQueue finishedQueue;
    private int counter =0;
    public Eater(ToastQueue toastQueue){
        this.finishedQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                Toast toast = finishedQueue.take();
                if(toast.getId()!= counter++ || toast.getStatus() != Toast.Status.JAMMED){
                    System.out.println(">>>>> Error: "+ toast);
                    System.exit(1);
                }else{
                    System.out.println("Chomp "+ toast);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted!");
        }
        System.out.println("eater off");
    }
}












































