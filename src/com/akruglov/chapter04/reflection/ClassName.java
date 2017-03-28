package com.akruglov.chapter04.reflection;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by akruglov on 28.03.17.
 */
public class ClassName {

    private class Inner {}

    public static <T> void printNames(T t) {
        System.out.println("Canonical: " + t.getClass().getCanonicalName());
        System.out.println("Simple: " + t.getClass().getSimpleName());
        System.out.println("Type name: " + t.getClass().getTypeName());
        System.out.println("Name: " + t.getClass().getName());
        System.out.println("String: " + t.getClass().toString());
        System.out.println("Generic: " + t.getClass().toGenericString());
    }

    public static <T> void printMethods(T t) {
        Class<?> cl = t.getClass();

        while (cl != null) {

            for (Method m : cl.getDeclaredMethods()) {
                System.out.print(Modifier.toString(m.getModifiers()) + " ");
                System.out.print(m.getReturnType().getCanonicalName() + " ");
                System.out.print(m.getName());
                System.out.println(Arrays.toString(m.getParameters()));
            }

            cl = cl.getSuperclass();
        }
    }

    public static void main(String[] args) {
        printNames(5);
        System.out.println("====================");
        printNames(new int[] { 6, 7 });
        System.out.println("====================");
        printNames(new ArrayList<String>());
        System.out.println("====================");
        printNames(new ClassName().new Inner());
        System.out.println("====================");

        // Load file from the same directory as this class

        InputStream stream = ClassName.class.getResourceAsStream("my.csv");
        Scanner in = new Scanner(stream);
        System.out.println(in.nextLine());
        in.close();

        System.out.println("====================");

        // Print classpath

        URL[] urls = ((URLClassLoader)ClassName.class.getClassLoader()).getURLs();

        for (URL url : urls) {
            System.out.println(url);
        }

        System.out.println("====================");

        printMethods(new int[] { 2, 3 });
    }
}
