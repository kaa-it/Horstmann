package com.akruglov.chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class Stacks {

    private static class Stack<E> {
        private ArrayList<E> array = new ArrayList<>();

        public boolean isEmpty() {
            return array.isEmpty();
        }

        public void push(E element) {
            array.add(element);
        }

        public E pop() {
            if (isEmpty()) {
                throw new IllegalStateException("No element in stack");
            }
            return array.remove(array.size() - 1);
        }
    }

    private static class StackArray<E> {
        private static int INITIAL_SIZE = 5;

        private E[] array;
        private int currentIndex = 0;

        public StackArray(IntFunction<E[]> constr) {
            array = constr.apply(INITIAL_SIZE);
        }

        public boolean isEmpty() {
            return currentIndex == 0;
        }

        public void push(E element) {
            if (currentIndex == array.length) {
                array = Arrays.copyOf(array, array.length * 2);
            }
            array[currentIndex++] = element;
        }

        public E pop() {
            if (isEmpty()) {
                throw new IllegalStateException("No element in stack");
            }

            currentIndex--;
            return array[currentIndex];
        }
    }
}
