package com.akruglov.chapter03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by akruglov on 26.03.17.
 */
public class SortUtil {

    private static boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {

        for (int i = 0; i < strings.size() - 1; i++) {
            if (comp.compare(strings.get(i), strings.get(i+1)) > 0)
                return false;
        }

        return true;
    }

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {

        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("dd");
        array.add("aa");
        array.add("dsgsv");
        array.add("dadasd");

        //array.sort((a, b) -> a.compareTo(b));

        System.out.println(array);

        luckySort(array, (a, b) -> a.compareTo(b));

        System.out.println(array);
    }
}
