package com.akruglov.chapter03;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by akruglov on 26.03.17.
 */
public class PrintDirectories {

    public static void main(String[] args) {
        File dir = new File("/home/akruglov");

        File[] files = dir.listFiles((f) -> f.isDirectory());

        if (files != null) {
            for (File d : files) {
                System.out.println(d);
            }
        }

        System.out.println("==========");

        files = dir.listFiles(File::isDirectory);

        if (files != null) {
            for (File d : files) {
                System.out.println(d);
            }
        }

        System.out.println("==========");

        files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (files != null) {
            for (File d : files) {
                System.out.println(d);
            }
        }
    }

}
