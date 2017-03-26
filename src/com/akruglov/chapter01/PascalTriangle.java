package com.akruglov.chapter01;

import java.util.ArrayList;

/**
 * Created by akruglov on 22.03.17.
 */
public class PascalTriangle {

    private static ArrayList<ArrayList<Integer>> createPascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            triangle.add(row);
            switch (i) {
                case 0:
                    row.add(1);
                    break;
                case 1:
                    row.add(1);
                    row.add(1);
                    break;
                default:
                    row.add(1);
                    for (int j = 1; j < i; j++) {
                        row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                    }
                    row.add(1);
                    break;
            }
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(createPascalTriangle(5));
    }
}
