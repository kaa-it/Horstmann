package com.akruglov.chapter06;

import java.util.ArrayList;

class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class Table<K, V> {

    private ArrayList<Entry<K, V>> table = new ArrayList<>();

    public void add(K key, V value) {
        table.add(new Entry<>(key, value));
    }

    public V getValue(K key) {
        for (Entry<K, V> e : table) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }

        return null;
    }

    public void setValue(K key, V value) {
        for (Entry<K, V> e : table) {
            if (e.getKey().equals(key)) {
                e.setValue(value);
            }
        }
    }
}
