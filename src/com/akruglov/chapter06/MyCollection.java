package com.akruglov.chapter06;

import java.util.Collection;
import java.util.List;

public class MyCollection {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {

    }

    /*
    public static Comparable void sort(List<Comparable> list)
     */

    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        for (T e : coll) {
            return e;
        }

        return null;
    }

    /*
    public static Comparable max(Collection<Comparable> coll)
     */

    // javap -c com.akruglov.chapter06.MyCollection
}
