package com.akruglov.chapter01;

import java.util.Scanner;

public class UnsignedInt {
    /**
     * number1 = 4123425345
     * number2 = 4123425341
     */
    public static void main(String[] args) {
        System.out.println("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        String strNumber1 = scanner.next();
        int number1 = Integer.parseUnsignedInt(strNumber1);
        String strNumber2 = scanner.next();
        int number2 = Integer.parseUnsignedInt(strNumber2);
        System.out.printf("%s, %s\n", Integer.toUnsignedString(number1), Integer.toUnsignedString(number2));
        System.out.printf("number1 = 0b%s\n", Integer.toBinaryString(number1));
        System.out.printf("number2 = 0b%s\n", Integer.toBinaryString(number2));
        System.out.printf("number2 + 3 = %s\n", Integer.toUnsignedString(number2 + 3));
        System.out.printf("number2 + 3 = 0b%s\n", Integer.toBinaryString(number2 + 3));
        System.out.printf("number2 - 4 = %s\n", Integer.toUnsignedString(number2 - 4));
        System.out.printf("number2 - 4 = 0b%s\n", Integer.toBinaryString(number2 - 4));
        System.out.printf("number1 + number2 = %s\n", Integer.toUnsignedString(number1 + number2));
        System.out.printf("number1 + number2 = 0b%s\n", Integer.toBinaryString(number1 + number2));
        System.out.printf("number1 - number2 = %s\n", Integer.toUnsignedString(number1 - number2));
        System.out.printf("number1 - number2 = 0b%s\n", Integer.toBinaryString(number1 - number2));
        System.out.printf("number2 - number1 = %s\n", Integer.toUnsignedString(number2 - number1));
        System.out.printf("number2 - number1 = 0b%s\n", Integer.toBinaryString(number2 - number1));
        System.out.printf("number1 / number2 = %s\n", Integer.toUnsignedString(number1 / number2));
        System.out.printf("number1 / number2 = 0b%s\n", Integer.toBinaryString(number1 / number2));
        System.out.printf("number1 %% number2 = %s\n", Integer.toUnsignedString(number1 % number2));
        System.out.printf("number1 %% number2 = 0b%s\n", Integer.toBinaryString(number1 % number2));
        System.out.printf("number1 / number2 = %s\n", Integer.toUnsignedString((int)(Integer.toUnsignedLong(number1) / Integer.toUnsignedLong(number2))));
        System.out.printf("number1 / number2 = 0b%s\n", Integer.toBinaryString((int)(Integer.toUnsignedLong(number1) / Integer.toUnsignedLong(number2))));
        System.out.printf("number1 %% number2 = %s\n", Integer.toUnsignedString((int)(Integer.toUnsignedLong(number1) % Integer.toUnsignedLong(number2))));
        System.out.printf("number1 %% number2 = 0b%s\n", Integer.toBinaryString((int)(Integer.toUnsignedLong(number1) % Integer.toUnsignedLong(number2))));
    }
}
