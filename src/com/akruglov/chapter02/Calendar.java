package com.akruglov.chapter02;

import java.time.LocalDate;

/**
 * Created by akruglov on 23.03.17.
 */
public class Calendar {

    private static int calculateIndent(int weekIndex) {
        if (weekIndex == 7) {
            return 0;
        } else {
            return weekIndex;
        }
    }

    private static void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(1956, 8, 1);

        System.out.println("Вс Пн Вт Ср Чт Пт Сб");

        LocalDate date = startDate;

        int weekIndex = date.getDayOfWeek().getValue();

        printIndent(calculateIndent(weekIndex));

        while (date.getMonthValue() == startDate.getMonthValue()) {
            System.out.printf("%02d", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 6) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
        }
    }
}
