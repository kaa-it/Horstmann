package com.akruglov.chapter02;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by akruglov on 26.03.17.
 */
public class CSV {

    public static void main(String[] args) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("my.csv"));

            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String s : nextLine) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
