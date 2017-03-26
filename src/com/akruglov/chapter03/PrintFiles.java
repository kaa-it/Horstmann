package com.akruglov.chapter03;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by akruglov on 26.03.17.
 */
public class PrintFiles {

    public static void main(String[] args) {
        File dir = new File("/home/akruglov/Projects");

        for (String file : dir.list((directory, name) -> name.endsWith(".zip"))) {
            System.out.println(file);
        }
    }
}
