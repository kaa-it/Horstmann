package com.akruglov.tests;

/**
 * Created by akruglov on 26.03.17.
 */
public class TestLambda {

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
            }
        };
        new Thread(r).start();
    }
}
