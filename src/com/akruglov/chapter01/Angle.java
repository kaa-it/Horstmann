package com.akruglov.chapter01;

import java.util.Scanner;

/**
 * Created by akruglov on 18.03.17.
 */
public class Angle {

    public static void main(String[] args) {
        System.out.println("Enter angle: ");
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        int coercedAngle = ((360 + angle) % 360 + 360) % 360;
        int autoCoercedAngle = Math.floorMod(angle, 360);
        System.out.println("Mannually coerced: " + coercedAngle);
        System.out.println("Auto coerced: " + autoCoercedAngle);
    }
}
