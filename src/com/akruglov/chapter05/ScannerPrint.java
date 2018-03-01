package com.akruglov.chapter05;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScannerPrint {

    /*
     * IllegalStateException can not be thrown as streams closed only by
     * our code after all other stream's operations.
     *
     * NoSuchElementException can not be thrown as we check that by
     * in.hasNext() method.
     *
     * SecurityException must be prevented by programmer.
     */

    public static void copyFiles() throws IOException {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(Paths.get("file.txt"));
            out = new PrintWriter("output.txt");

            while (in.hasNext())
                out.println(in.next().toLowerCase());
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void copyFilesWithTryResources() throws IOException {
        try (Scanner in = new Scanner(Paths.get("file.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {
            while (in.hasNext())
                out.println(in.next().toLowerCase());
        }
    }

    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(Paths.get("file.txt"));
            out = new PrintWriter("output.txt");

            while (in.hasNext())
                out.println(in.next().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
