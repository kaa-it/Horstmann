package com.akruglov.chapter07;

import java.util.*;

public class Others {

    public static void capitalizeStringArray() {
        List<String> a = new ArrayList<>();
        a.add("hdsjds");
        a.add("kkksdsd");
        a.add("hdhaaa");

        ListIterator<String> it = a.listIterator();

        while (it.hasNext()) {
            it.set(it.next().toUpperCase());
        }

        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i).toLowerCase());
        }

        a.replaceAll(String::toUpperCase);

        System.out.println(a);
    }

    public static void sets() {
        Set<String> a = new TreeSet<>();
        a.add("a");
        a.add("b");
        a.add("c");

        Set<String> b = new TreeSet<>();
        b.add("c");
        b.add("d");

        // Union
        //a.addAll(b);

        // Difference
        //a.removeAll(b);

        // Intersection
        a.retainAll(b);

        System.out.println(a);
    }

    private static <T> void swapRandomHelper(List<T> list, int i, int j) {
        System.out.println("swapRandomHelper called");

        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static <T> void swapHelper(List<T> list, int i, int j) {
        System.out.println("swapHelper called");

        int index = 0;
        T temp = null;
        ListIterator<T> it = list.listIterator();

        while (it.hasNext() && index <= j) {
            T elem = it.next();
            if (index == i) {
                temp = elem;
            } else if (index == j) {
                it.set(temp);
                temp = elem;
            }
            index++;
        }

        list.set(i, temp);
    }

    public static void swap(List<?> list, int i, int j) {
        if (list instanceof RandomAccess) {
            swapRandomHelper(list, i, j);
        } else {
            swapHelper(list, i, j);
        }
    }

    // TODO: Exercise 7.

    public static void main(String[] args) {
        capitalizeStringArray();
        sets();

        ArrayList<String> a = new ArrayList<>();
        a.add("dsdsd");
        a.add("rtrtrt");
        a.add("fgfgfg");
        a.add("fsdsdd");

        swap(a, 1, 2);

        System.out.println(a);

        LinkedList<String> b = new LinkedList<>();
        b.add("dsdsd");
        b.add("rtrtrt");
        b.add("fgfgfg");
        b.add("fsdsdd");

        swap(b, 1, 2);

        System.out.println(b);
    }
}
