package com.akruglov.chapter03;

/**
 * Created by akruglov on 26.03.17.
 */
public class RunnableHelper {

    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            new Thread(task).start();
        }
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
