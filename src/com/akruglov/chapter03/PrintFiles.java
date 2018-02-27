package com.akruglov.chapter03;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by akruglov on 26.03.17.
 */
public class PrintFiles {

    public static void main(String[] args) {
        File dir = new File("/home/akruglov/Projects");

        String[] zipFiles = dir.list((directory, name) -> name.endsWith(".zip"));

        if (zipFiles != null) {
            for (String file : zipFiles) {
                System.out.println(file);
            }
        }
    }
}
