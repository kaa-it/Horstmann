package com.akruglov.chapter01;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by akruglov on 22.03.17.
 */
public class Lottery {
    public static void main(String[] args) {
        ArrayList<Integer> barrel = new ArrayList<>();

        for (int i = 1; i < 50; i++) {
            barrel.add(i);
        }

        Random random = new Random(LocalTime.now().toNanoOfDay());

        final int CHOISES = 6;

        ArrayList<Integer> win = new ArrayList<>();

        for (int i = 0; i < CHOISES; i++) {
            int choise = random.nextInt(barrel.size());
            win.add(barrel.remove(choise));
        }

        Collections.sort(win);

        System.out.println(win.toString());
    }
}
