package com.akruglov.chapter03;

import java.util.Random;

/**
 * Created by akruglov on 26.03.17.
 */

class RandomUtilImpl {

    private static Random generator = new Random();

    private static class RandomSequence implements IntSequence {

        private int low;
        private int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }
}


public class RandomUtil {
    public static void main(String[] args) {
        IntSequence seq = RandomUtilImpl.randomInts(4, 9);
    }
}
