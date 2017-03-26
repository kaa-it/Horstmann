package com.akruglov.chapter03;

/**
 * Created by akruglov on 26.03.17.
 */
public class TestIntSequence {

    public static void main(String[] args) {
        IntSequence sequence = IntSequence.of(1, 4, 8, 19);

        while (sequence.hasNext()) {
            System.out.println(sequence.next());
        }

        IntSequence constantSequence = IntSequence.constant(88);

        for (int i = 0; i < 5; i++) {
            System.out.println(constantSequence.next());
        }
    }
}
