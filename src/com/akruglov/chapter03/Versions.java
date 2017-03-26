package com.akruglov.chapter03;


import com.akruglov.test.MyInterface;
import com.akruglov.test.VersionX;

/**
 * Created by akruglov on 26.03.17.
 */
class Version1 implements MyInterface {

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int next() {
        return 6;
    }

    @Override
    public void remove() {

    }

    @Override
    public void foreachRemaining() {

    }
}

public class Versions {
    public static void main(String[] args) {
        MyInterface ver1 = new Version1();

        for (int i = 0; i < 15; i++) {
            System.out.println(ver1.next());
        }

        MyInterface verx = new VersionX();

        for (int i = 0; i < 15; i++) {
            System.out.println(verx.next());
        }

        verx.remove();
        verx.foreachRemaining();
    }
}
