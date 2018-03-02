package com.akruglov.chapter06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pair<E extends Comparable<E>> {
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E max() {
        if (first.compareTo(second) > 0) {
            return first;
        } else {
            return second;
        }
    }

    public E min() {
        if (first.compareTo(second) < 0) {
            return first;
        } else {
            return second;
        }
    }
}

class Lists {
    public static void swap(List<?> elements, int i, int j) {
        swapHelper(elements, i, j);
    }

    public static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}

class Arrays {
    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<? extends E> a) {
        return new Pair<>(a.get(0), a.get(a.size() -1));
    }

    public static <E extends Comparable<E>> E min(ArrayList<? extends E> a) {
        E result = a.get(0);

        for (E e : a) {
            if (e.compareTo(result) < 0) {
                result = e;
            }
        }

        return result;
    }

    public static <E extends Comparable<E>> E max(ArrayList<? extends E> a) {
        E result = a.get(0);

        for (E e : a) {
            if (e.compareTo(result) > 0) {
                result = e;
            }
        }

        return result;
    }

    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<? extends E> a) {
        return new Pair<>(min(a), max(a));
    }

    public static <T> void minmax(List<T> elements, Comparator<? super T> comp,
                                  List<? super T> result) {
        T min = elements.get(0);
        T max = elements.get(0);

        for (T e : elements) {
            if (comp.compare(e, min) < 0) {
                min = e;
            }
            if (comp.compare(e, max) > 0) {
                max = e;
            }
        }

        result.add(min);
        result.add(max);
    }

    public static <T> void maxmin(List<T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        Lists.swap(result, 0, 1);
    }
}
