package com.akruglov.chapter03;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by akruglov on 26.03.17.
 */
public class PrintDirectories {

    public static void main(String[] args) {
        File dir = new File("/home/akruglov");

        for (File d : dir.listFiles((f) -> f.isDirectory())) {
            System.out.println(d);
        }

        System.out.println("==========");

        for (File d : dir.listFiles(File::isDirectory)) {
            System.out.println(d);
        }

        System.out.println("==========");

        for (File d : dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        })) {
            System.out.println(d);
        }
    }

}
