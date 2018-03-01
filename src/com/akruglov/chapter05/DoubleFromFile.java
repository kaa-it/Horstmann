package com.akruglov.chapter05;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoubleFromFile {
    /**
     * Read array of doubles from file
     * @param filename Name of file to read doubles
     * @return array of doubles
     * @throws IOException if can not open given file
     * @throws java.util.InputMismatchException if wrong data was entered
     * @throws java.util.NoSuchElementException if input is exhausted
     */
    public static ArrayList<Double> readValues(String filename) throws IOException {
        Scanner in = new Scanner(Paths.get(filename), "UTF-8");
        ArrayList<Double> values = new ArrayList<>();
        while (in.hasNext()) {
            values.add(in.nextDouble());
        }
        return values;
    }

    /**
     * Computes sum if doubles from given file
     * @param filename name of file to read doubles
     * @return sum of doubles
     * @throws IOException if can not open given file
     * @throws java.util.InputMismatchException if wrong data was entered
     * @throws java.util.NoSuchElementException if input is exhausted
     */
    public static double sumOfValues(String filename) throws IOException {
        ArrayList<Double> values = readValues(filename);

        double sum = 0;
        for (Double value : values) {
            sum += value;
        }

        return sum;
    }

    public static void main(String[] args) {
        try {
            System.out.printf("Sum is %f\n", sumOfValues("file.txt"));
        } catch (IOException e) {
            System.out.println("Can not open file.");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Entered wrong data.");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("Input is exhausted.");
            e.printStackTrace();
        }
    }
}
