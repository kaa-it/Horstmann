package com.akruglov.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by akruglov on 26.03.17.
 */
public class Greeter implements Runnable {

    private String target;
    private int n;

    public Greeter(String target, int n) {
        this.target = target;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello, " + target);
        }
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        Greeter g1 = new Greeter("Vasya", 15);
        Greeter g2 = new Greeter("Petya", 20);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(g1);
        executor.execute(g2);

        executor.shutdown();

//        Thread t1 = new Thread(g1);
//        Thread t2 = new Thread(g2);
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
