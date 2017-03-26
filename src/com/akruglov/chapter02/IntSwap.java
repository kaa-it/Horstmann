package com.akruglov.chapter02;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.IntHolder;

/**
 * Created by akruglov on 23.03.17.
 */
public class IntSwap {

    private static void swapIntReferences() {
        Integer a = 5;
        Integer b = 6;

        System.out.printf("a: %h, b: %h\n", a, b);

        Integer temp = a;
        a = b;
        b = temp;

        System.out.printf("a: %h, b: %h\n", a, b);
    }

    // Swap int references' fields not available because of autoboxing

    private static void swapIntHolders() {
        IntHolder c = new IntHolder();
        IntHolder d = new IntHolder();
        c.value = 5;
        d.value = 8;

        System.out.println("c: " + c.value + ", d: " + d.value);

        int temp = c.value;
        c.value = d.value;
        d.value = temp;

        System.out.println("c: " + c.value + ", d: " + d.value);
    }

    public static void main(String[] args) {
        swapIntReferences();
        // ===========================
        swapIntHolders();
    }
}
