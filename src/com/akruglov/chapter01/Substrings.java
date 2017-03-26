package com.akruglov.chapter01;

import java.util.Scanner;

/**
 * Created by akruglov on 18.03.17.
 */
public class Substrings {

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();


        for (int j = 0; j < text.length(); j++) {
            for (int i = j+1; i <= text.length(); i++) {
                String substring = text.substring(j, i);

                if (!substring.trim().isEmpty()) {
                    System.out.println(substring);
                }
            }
        }
    }
}
