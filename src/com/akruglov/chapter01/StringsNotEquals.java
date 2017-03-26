package com.akruglov.chapter01;

/**
 * Created by akruglov on 22.03.17.
 */
public class StringsNotEquals {
    public static void main(String[] args) {
        String one = "test";
        String two = "testu".replace("u","");
        System.out.println("Strings not same: " + (one != two));
    }
}
