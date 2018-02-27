package com.akruglov.chapter03;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by akruglov on 26.03.17.
 */
public class SortFiles {
    public static void main(String[] args) {
        File dir = new File("/home/akruglov/Documents/Android Yandex (notes)");

        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("The directory is empty.");
            return;
        }

        for (File file : files) {
            System.out.println(file);
        }

        Arrays.sort(files, (o1, o2) -> {
                if (o1.isDirectory() && o2.isDirectory()) {
                    return o1.getName().compareTo(o2.getName());
                } else if (o1.isDirectory() && !o2.isDirectory()){
                    return -1;
                } else if (!o1.isDirectory() && o2.isDirectory()) {
                    return 1;
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
        });

        System.out.println("=================");

        for (File file : files) {
            System.out.println(file);
        }
    }
}
