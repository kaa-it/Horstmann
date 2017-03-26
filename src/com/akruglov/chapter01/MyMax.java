package com.akruglov.chapter01;

import java.util.Scanner;

/**
 * Created by akruglov on 18.03.17.
 */
public class MyMax {

    public static void main(String[] args) {
        System.out.println("Enter three numbers: ");
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();

        int temp = number1 > number2 ? number1 : number2;
        int max = temp > number3 ? temp : number3;

        System.out.println("Mannually max: " + max);

        temp = Math.max(number1, number2);
        max = Math.max(temp, number3);

        System.out.println("Auto max: " + max);
    }
}
