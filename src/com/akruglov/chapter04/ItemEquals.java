package com.akruglov.chapter04;

import java.util.Objects;;

class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Item)) return false;

        Item other = (Item) otherObject;

        return Objects.equals(description, other.description) && price == other.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}

class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;

        if (otherObject.getClass() == Item.class) {
            return true;
        }

        DiscountedItem other = (DiscountedItem) otherObject;

        return discount == other.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}

public class ItemEquals {
    public static void main(String[]args){
        Item item = new Item("test", 2);
        DiscountedItem discountedItem = new DiscountedItem("test", 2, 1.0/3);
        DiscountedItem otherDiscountedItem = new DiscountedItem("test", 2, 1.0/3);
        DiscountedItem anotherDiscountedItem = new DiscountedItem("test", 2, 2.0/3);

        System.out.println(discountedItem.equals(item));
        System.out.println(item.equals(discountedItem));
        System.out.println(discountedItem.equals(otherDiscountedItem));
        System.out.println(item.equals(anotherDiscountedItem));
        System.out.println(discountedItem.equals(anotherDiscountedItem));
    }
}
