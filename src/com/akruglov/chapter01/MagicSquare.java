package com.akruglov.chapter01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by akruglov on 22.03.17.
 */
public class MagicSquare {

    private static int[] parseLine(String line) {
        String[] values = line.split("\\s");
        int[] row = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            row[i] = Integer.parseInt(values[i]);
        }
        return row;
    }

    private static int sum(int[] array) {
        int total = 0;
        for (int v : array) {
            total += v;
        }
        return total;
    }

    private static int sumColumn(int[][] array, int column) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i][column];
        }
        return total;
    }

    private static int sumDiag(int[][]array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i][i];
        }
        return total;
    }

    private static int sumCollateralDiag(int[][]array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i][array.length - i - 1];
        }
        return total;
    }

    private static boolean isMagic(int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int magic = sum(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (magic != sum(array[i])) {
                return false;
            }
        }

        for (int i = 0; i < array[0].length; i++) {
            if (magic != sumColumn(array, i)) {
                return false;
            }
        }

        if (magic != sumDiag(array) || magic != sumCollateralDiag(array)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            int[][] array = null;
            int numLines = 0;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.trim().isEmpty()) {
                    break;
                }
                int[] row = parseLine(line);
                if (array == null) {
                    array = new int[row.length][];
                }
                if (row.length != array.length) {
                    System.out.println("All lines must have the same amount of numbers");
                    in.close();
                    return;
                }

                array[numLines] = row;
                numLines++;

                if (numLines == array.length) {
                    break;
                }
            }
            System.out.println(Arrays.deepToString(array));

            System.out.println("Array is magic: " + isMagic(array));

        } catch (NumberFormatException ex) {
            System.out.println("Error: Can not parse line");
        }

        in.close();
    }
}
