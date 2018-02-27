package com.akruglov.chapter03;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by akruglov on 26.03.17.
 */
public class RunnableHelper {

    public static void runTogether(Runnable... tasks) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        });
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static Runnable serialRunner(Runnable... tasks) {
        return () -> {
            for (Runnable task : tasks) {
                task.run();
            }
        };
    }
}
