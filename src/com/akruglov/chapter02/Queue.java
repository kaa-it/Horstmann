package com.akruglov.chapter02;

/**
 * Created by akruglov on 26.03.17.
 */
public class Queue<T> {

    Node<T> head;
    Node<T> tail;

    private static class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public void addNode(Node<T> node) {
            next = node;
        }
    }

    public void put(T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = tail = node;
        } else {
            tail.addNode(node);
            tail = node;
        }
    }

    public T get() {
        if (head == null) {
            return null;
        } else {
            T value = head.value;
            head = head.next;
            return value;
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }

    private class Iterator {

        public boolean hasNext() {
            return head != null;
        }

        public T next() {
            T value = head.value;
            head = head.next;
            return value;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.put("aaa");
        queue.put("bbb");
        queue.put("ccc");

//        String str = null;
//
//        while ((str = queue.get()) != null) {
//            System.out.println(str);
//        }

        Queue<String>.Iterator iter = queue.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
