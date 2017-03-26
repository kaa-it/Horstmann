package com.akruglov.chapter02;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by akruglov on 26.03.17.
 */
public class RandomNumbers {

    private static Random random = new Random();

    public static <T> T randomElement(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int index = random.nextInt(array.length);
        return array[index];
    }

    public static <T> T randomElement(ArrayList<T> array) {
        if (array.isEmpty()) {
            throw new IllegalArgumentException("Array is empty");
        }
        int index = random.nextInt(array.size());
        return array.get(index);
    }

    // TODO: Write method for array of primitive types

    public static void main(String[] args) {
        Integer[] a = {6, 8, 9};

        ArrayList<String> b = new ArrayList<>();
        b.add("First");
        b.add("Second");
        b.add("Third");

        System.out.println(randomElement(a));
        System.out.println(randomElement(b));
    }
}
