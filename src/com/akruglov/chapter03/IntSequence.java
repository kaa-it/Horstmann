package com.akruglov.chapter03;

/**
 * Created by akruglov on 26.03.17.
 */
public interface IntSequence {

    default boolean hasNext() {
        return true;
    }

    int next();

    static IntSequence of(int... values) {
        return new IntSequence() {
            int index;

            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public int next() {
                int value = values[index];
                index++;
                return value;
            }
        };
    }

    static IntSequence constant(int value) {
        return () -> value;
    }
}
