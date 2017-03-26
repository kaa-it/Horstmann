package com.akruglov.chapter01;

import java.util.Scanner;

public class PrintInteger {

    public static void main(String[] args) {
	    System.out.println("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.printf("Your number: 0b%s, %#o, %<#x\n", Integer.toBinaryString(number), number);
    }
}
