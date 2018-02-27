package com.akruglov.chapter04.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloWorld {
    public static void main(String[] args) {
        try {
            Object out = System.class.getField("out").get(null);
            System.out.println("");
            Method m = out.getClass().getMethod("println", String.class);
            m.invoke(out, "Hello World!!!");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
