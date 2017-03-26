package com.akruglov.chapter01;

import java.time.LocalTime;
import java.util.Random;

/**
 * Created by akruglov on 22.03.17.
 */
public class GenerateString {
    public static void main(String[] args) {
        Random random = new Random(LocalTime.now().toNanoOfDay());
        long value = random.nextLong();
        System.out.println(Long.toString(value, 36));
    }
}
