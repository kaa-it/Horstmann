package com.akruglov.chapter02;

import java.util.ArrayList;

/**
 * Created by akruglov on 26.03.17.
 */
public class Invoice {

    public static class Item {
        private String description;
        private int quantity;
        private double unitPrice;

        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        double price() {
            return quantity * unitPrice;
        }
    }

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String description, int quantity, double unitPrice) {
        Item newItem = new Item(description, quantity, unitPrice);
        items.add(newItem);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "items=" + items +
                '}';
    }

    public void print() {
        System.out.println("Invoice details:");

        int i = 0;

        for (Item item : items) {
            System.out.println("    Item " + (++i) + ":");
            System.out.println("        Description: " + item.getDescription());
            System.out.println("        Quantity: " + item.getQuantity());
            System.out.printf("        Unit price: %.2f\n", item.getUnitPrice());
            System.out.printf("        Price: %.2f\n", item.price());
        }

        if (i == 0) {
            System.out.println("Empty");
        }
    }

    public static void main(String[] args) {
        Invoice empty = new Invoice();
        empty.print();

        Invoice full = new Invoice();
        for (int i = 0; i < 15; i++) {
            full.addItem("dfhkjsdhfk" + (i + 1), 67 + i, 78.9 * (i + 1));
        }

        full.print();
    }
}
