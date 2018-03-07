package com.akruglov.chapter07;

import java.util.*;

public class Erathostenes {

    public static Set<Integer> primeTreeSet(int n) {
        TreeSet<Integer> primes = new TreeSet<>();

        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }

        Integer elem = Collections.min(primes);

        while (elem != null) {

            int val = elem * elem;

            if (val > n) {
                break;
            }

            for (int i = 0; val <= n; val = elem * (elem + i)) {
                primes.remove(val);
                i++;
            }

            elem = primes.higher(elem);
        }

        return primes;
    }

    public static BitSet primeBitSet(int n) {
        BitSet primes = new BitSet(n);
        primes.set(1, n, true);

        int index = 1;

        while (true) {
            int elem = index + 1;

            int val = elem * elem;

            if (val > n) {
                break;
            }

            for (int i = 0; val <= n; val = elem * (elem + i)) {
                primes.set(val - 1, false);
                i++;
            }

            index = primes.nextSetBit(index + 1);

            System.out.println(primes);
        }

        return primes;
    }

    public static void main(String[] args) {
        System.out.println(primeTreeSet(50).toString());
        System.out.println(primeBitSet(50).toString());
    }

}
